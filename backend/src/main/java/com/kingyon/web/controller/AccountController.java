package com.kingyon.web.controller;


import com.kingyon.common.domain.account.Login;
import com.kingyon.partybuild.domain.SecurityCode;
import com.kingyon.partybuild.domain.user.User;
import com.kingyon.partybuild.service.ISecurityCodeService;
import com.kingyon.partybuild.service.UserService;
import com.kingyon.partybuild.support.util.SmsUtils;
import com.kingyon.partybuild.util.Validations;
import com.kingyon.web.utils.AbstractController;
import com.kingyon.web.utils.SecurityUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 帐号相关URL
 * <p/>
 *
 * @author <a href="libing@kingyon.com">Libing Huang</a>
 * 2017/8/7 下午4:29
 * @since 0.1.0
 */
@Controller
public class AccountController extends AbstractController {
    @Autowired
    private UserService userService;

    @Autowired
    private ISecurityCodeService securityCodeService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * 注册验证码标识
     */
    private static final String FIND_PASSWORD_CODE = "FIND_PASS_CODE_BACK";

    /**
     * 获取注册验证码
     *
     * @param mobile
     * @return
     */
    @RequestMapping(value = "/captcha", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> captcha(@RequestParam String mobile) {

        Map<String, Object> result = new HashMap<>();

        String message = validateSendSecurityCodeInfo(mobile, FIND_PASSWORD_CODE, 60);
        if (StringUtils.isNotBlank(message)) {
            result.put("flag", "false");
            result.put("message", message);
            return result;
        }
        SecurityCode securityCode = securityCodeService.generate(mobile, FIND_PASSWORD_CODE, 10);//生成验证码
        SmsUtils.sendMessage("66765", mobile, securityCode.getValue());

        result.put("flag", "true");
        result.put("message", "发送成功");

        return result;
    }

    /**
     * 验证发送短信手机号码(格式以及发送频率)
     *
     * @param mobile 待发送的手机号码
     * @return 验证码
     */
    private String validateSendSecurityCodeInfo(String mobile, String type, int intervalTime) {
        if (StringUtils.isBlank(mobile)) {
            return "手机号码不能为空";
        }
        if (!Validations.isMobile(mobile)) {
            return "手机号格式不正确";
        }

        //获取验证码
        SecurityCode securityCode = securityCodeService.get(mobile, type);
        if (securityCode != null && intervalTime > 0) {

            //账户注册验证码重复发送的时间限制
            long intervalMillis = intervalTime * 1000;
            long diff = System.currentTimeMillis() - securityCode.getCreateTime();
            if (diff < intervalMillis) {
                return "验证码获取间隔时间不能少于" + intervalTime + "秒";
            }
        }
        return null;
    }

    /**
     * 登陆
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private String login() {
        return "login";
    }

    @RequestMapping(value = "/loading")
    public String loading() {
        Login currentUser = SecurityUtils.getCurrentUser();
        Collection<? extends GrantedAuthority> authorities = currentUser.getAuthorities();
        if (authorities.contains(new SimpleGrantedAuthority("ROLE_SERVICE"))) {
            return "redirect:service/index";
        }
        return "redirect:/";
    }

    /**
     * 找回密码
     */
    @RequestMapping(value = "/tobackpassword")
    public String toBackPassword() {
        return "backpassword";
    }


    /**
     * 修改密码
     */
    @RequestMapping(value = "/changepass", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> changePass(@RequestParam String mobile, @RequestParam String code, @RequestParam String pass) {

        Map<String, Object> result = new HashMap<>();

        String message = "";
        if (StringUtils.isNotBlank(message = validCaptcha(mobile, FIND_PASSWORD_CODE, code))) {
            result.put("flag", "false");
            result.put("message", message);
            return result;
        }

        /*List<personal> users=new ArrayList<>();
        //users=userService.findUserByMobile(mobile);
        if(users!=null){
            personal personal=users.get(0);
            if ("验证码".equals(code)){
                if(pass !=null){
                    personal.setPassword(pass);
                    //userService.save(personal);
                    return "changepassok";
                }
            }
        }*/

        User user = userService.findUserByMobile(mobile);
        try {
            user.setPassword(passwordEncoder.encodePassword(pass, mobile));
            userService.save(user);
            result.put("flag", "true");
            result.put("message", "修改成功");
            //操作完成后删除验证码信息
            securityCodeService.delete(mobile, FIND_PASSWORD_CODE);
        } catch (Exception e) {
            result.put("flag", "false");
            result.put("message", "修改失败");
        }

        return result;
    }

    /**
     * 校验验证码的正确性
     *
     * @param mobile  待验证的手机号码
     * @param type    验证码类型
     * @param captcha 待验证的验证码
     * @return 验证的结果, 没有问题返回null, 否则返回具体的错误信息
     */
    private String validCaptcha(String mobile, String type, String captcha) {

        //TODO 测试使用
        if ("123456".equals(captcha)) {
            return null;
        }

        SecurityCode securityCode = null;
        if ((securityCode = securityCodeService.get(mobile, type)) == null || securityCode.isExpred()) {
            return "验证码不存在或已过期";
        }
        if (captcha.equalsIgnoreCase(securityCode.getValue())) {
            return null;
        } else {
            return "验证码不正确";
        }
    }

    /**
     * 找回密码成功
     */
    @RequestMapping(value = "/changepassok")
    public String toChangePassOk() {
        return "changepassok";
    }


}
