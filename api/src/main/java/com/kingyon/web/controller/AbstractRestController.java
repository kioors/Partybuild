package com.kingyon.web.controller;

import com.kingyon.common.controller.AbstractController;
import com.kingyon.partybuild.model.MemberModel;
import com.kingyon.partybuild.support.service.IRestSecurityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * describe：前端接口抽象类
 *
 * @author <a href="sam@kingyon.com">Yang Xiang</a>
 * 2017/7/17 13:44
 * @since 0.1.0
 */
public abstract class AbstractRestController extends AbstractController {

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


//    @Autowired
//    protected IRestSecurityService restSecurityService;
//
//
//    /**
//     * 抽离客户端输入错误信息
//     * 获取请求参数的错误信息(暂时设定为只要有错误就返回'参数不正确')
//     *
//     * @param result 客户端验证结果
//     * @return Errors 错误信息
//     */
////    protected Errors extractErrors(BindingResult result) {
////        Errors errors = new Errors();
////        List<ObjectError> allErrors = result.getAllErrors();
////        for (ObjectError error : allErrors) {
////            if (error instanceof FieldError) {
////                errors.addFieldError(((FieldError) error).getField(), error.getDefaultMessage());
////            } else {
////                errors.addObjectError(error.getObjectName(), error.getDefaultMessage());
////            }
////        }
////        return errors;
////    }
//
//    /**
//     * 抽离客户端输入错误信息
//     * 获取请求参数的错误信息(暂时设定为只要有错误就返回'参数不正确')
//     *
//     * @param result 客户端验证结果
//     * @return Errors 错误信息
//     */
//    protected String extractErrors(BindingResult result) {
//        List<ObjectError> allErrors = result.getAllErrors();
//        if (allErrors != null && !allErrors.isEmpty()) {
//            return "参数不正确";
//        }
//        return null;
//    }
}
