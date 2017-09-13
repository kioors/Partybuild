package com.kingyon.web.controller;

import com.kingyon.common.model.AccountModel;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 帐号相关URL
 * <p/>
 *
 * @author <a href="libing@kingyon.com">Libing Huang</a>
 * 2017/8/7 下午4:29
 * @since 0.1.0
 */
@Api(description = "账号认证相关接口")
@RestController
@RequestMapping(value = "/rest/account")
public class AccountController extends AbstractRestController {
    @Override
    protected AccountModel getCurrentUser() {
        return null;
    }

//    @Autowired
//    private ISecurityCodeService securityCodeService;
//
//    /**
//     * 注册验证码标识
//     */
//    private static final String REGISTRY_SECURITY_CODE = "REGISTRY_SECURITY_CODE_REST";
//
//    /**
//     * 获取注册验证码
//     *
//     * @param mobile
//     * @return
//     */
//    @ApiOperation(value = "获取注册验证码")
//    @RequestMapping(value = "/captcha", method = RequestMethod.GET)
//    public RestResponse<ObjectUtils.Null> captcha(@RequestParam @ApiParam(value = "待校验的手机号码") String mobile) {
//        String message = validateSendSecurityCodeInfo(mobile, REGISTRY_SECURITY_CODE, 60);
//        if (StringUtils.isNotBlank(message)) {
//            return new RestResponse<>(ResponseStatus.BAD_REQUEST, null, message);
//        }
//        SecurityCode securityCode = securityCodeService.generate(mobile, REGISTRY_SECURITY_CODE, 10);//生成验证码
//        SmsUtils.sendMessage("66765", mobile, securityCode.getValue());
//        return new RestResponse<>(ResponseStatus.OK, null, "发送成功");
//    }
//
//    /**
//     * 验证发送短信手机号码(格式以及发送频率)
//     *
//     * @param mobile 待发送的手机号码
//     * @return 验证码
//     */
//    private String validateSendSecurityCodeInfo(String mobile, String type, int intervalTime) {
//        if (StringUtils.isBlank(mobile)) {
//            return "手机号码不能为空";
//        }
//        if (!Validations.isMobile(mobile)) {
//            return "手机号格式不正确";
//        }
//
//        //获取验证码
//        SecurityCode securityCode = securityCodeService.get(mobile, type);
//        if (securityCode != null && intervalTime > 0) {
//
//            //账户注册验证码重复发送的时间限制
//            long intervalMillis = intervalTime * 1000;
//            long diff = System.currentTimeMillis() - securityCode.getCreateTime();
//            if (diff < intervalMillis) {
//                return "验证码获取间隔时间不能少于" + intervalTime + "秒";
//            }
//        }
//        return null;
//    }
//
//    /**
//     * 认证
//     *
//     * @param mobile  待发送的手机号码
//     * @param name    真实姓名
//     * @param captcha 待校验的验证码
//     */
//    @RequestMapping(value = "/authentication", method = RequestMethod.POST)
//    @ApiOperation(value = "进行认证")
//    public RestResponse<ObjectUtils.Null> authentication(@RequestParam @ApiParam(value = "手机号码") String mobile,
//                                                         @RequestParam @ApiParam(value = "姓名") String name,
//                                                         @RequestParam @ApiParam(value = "验证码") String captcha) {
//        Long userId = getCurrentUserId();
//        if (userId == null) {
//            return new RestResponse(ResponseStatus.NOT_LOGIN, null, "登陆状态异常");
//        }
//        String message = "";
//        if (StringUtils.isNotBlank(message = validCaptcha(mobile, REGISTRY_SECURITY_CODE, captcha))) {
//            return new RestResponse<>(ResponseStatus.BAD_REQUEST, null, message);
//        }
//        //操作完成后删除验证码信息
//        securityCodeService.delete(mobile, REGISTRY_SECURITY_CODE);
//        return new RestResponse<>(ResponseStatus.OK, null, "认证成功");
//    }
//
//    /**
//     * 校验验证码的正确性
//     *
//     * @param mobile  待验证的手机号码
//     * @param type    验证码类型
//     * @param captcha 待验证的验证码
//     * @return 验证的结果, 没有问题返回null, 否则返回具体的错误信息
//     */
//    private String validCaptcha(String mobile, String type, String captcha) {
//
//        //TODO 测试使用
//        if ("123456".equals(captcha)) {
//            return null;
//        }
//
//        SecurityCode securityCode = null;
//        if ((securityCode = securityCodeService.get(mobile, type)) == null || securityCode.isExpred()) {
//            return "验证码不存在或已过期";
//        }
//        if (captcha.equalsIgnoreCase(securityCode.getValue())) {
//            return null;
//        } else {
//            return "验证码不正确";
//        }
//    }
}


