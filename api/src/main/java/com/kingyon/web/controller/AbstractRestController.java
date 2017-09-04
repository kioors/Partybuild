package com.kingyon.web.controller;

import com.kingyon.common.controller.AbstractController;
import com.kingyon.partybuild.model.MemberModel;
import com.kingyon.partybuild.support.service.IRestSecurityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * describe：前端接口抽象类
 *
 * @author <a href="sam@kingyon.com">Yang Xiang</a>
 * 2017/7/17 13:44
 * @since 0.1.0
 */
public abstract class AbstractRestController extends AbstractController<MemberModel> {

    @Autowired
    protected IRestSecurityService restSecurityService;

    @Override
    protected MemberModel getCurrentUser() {

        String token = getToken();

        if (!StringUtils.isEmpty(token)) {

            return restSecurityService.getUserByToken(token);
        }

        return null;
    }

    protected Long getCurrentUserId() {

        String token = getToken();

        if (!StringUtils.isEmpty(token)) {

            return restSecurityService.getUserIdByToken(token);
        }

        return null;
    }


    /**
     * <p>
     * 返回当前客户端的openId
     * </p>
     *
     * @return 客户端openId
     */
    protected String getOpenId() {

        HttpServletRequest request = getCurrentRequest();

        return request.getHeader(TOKEN_HEADER);
    }

    /**
     * 跟据openid获取当前本地用户信息,如果有则返回本地信息,没有则返回null
     *
     * @param openId
     * @return
     */
    protected MemberModel getWxCurrentUserByOpenId(String openId) {

        if (StringUtils.isNotBlank(openId)) {

            return restSecurityService.getUserByOpenId(openId);
        }

        return null;
    }

    /**
     * 抽离客户端输入错误信息
     * 获取请求参数的错误信息(暂时设定为只要有错误就返回'参数不正确')
     *
     * @param result 客户端验证结果
     * @return Errors 错误信息
     */
//    protected Errors extractErrors(BindingResult result) {
//        Errors errors = new Errors();
//        List<ObjectError> allErrors = result.getAllErrors();
//        for (ObjectError error : allErrors) {
//            if (error instanceof FieldError) {
//                errors.addFieldError(((FieldError) error).getField(), error.getDefaultMessage());
//            } else {
//                errors.addObjectError(error.getObjectName(), error.getDefaultMessage());
//            }
//        }
//        return errors;
//    }

    /**
     * 抽离客户端输入错误信息
     * 获取请求参数的错误信息(暂时设定为只要有错误就返回'参数不正确')
     *
     * @param result 客户端验证结果
     * @return Errors 错误信息
     */
    protected String extractErrors(BindingResult result) {
        List<ObjectError> allErrors = result.getAllErrors();
        if (allErrors != null && !allErrors.isEmpty()) {
            return "参数不正确";
        }
        return null;
    }
}
