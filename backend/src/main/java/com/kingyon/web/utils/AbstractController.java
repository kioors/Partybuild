package com.kingyon.web.utils;


import com.kingyon.partybuild.domain.user.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;


/**
 * 基础的rest Controller.
 * <p/>
 *
 * @author <a href="sam@kingyon.com">Yang Xiang</a>
 * 2017/5/23
 * @since 0.1.0
 */
public class AbstractController {

    /**
     * 获取当前登录用户
     *
     * @return
     */
    protected User getPrincipal() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User) {
            return (User) principal;
        }
        return null;
    }

    /**
     * @param result 客户端验证结果
     * @return Errors 错误信息
     * @Description: 抽离客户端输入错误信息
     * @author Jimmy
     * @date 2016-5-4
     */
    protected Errors extractErrors(BindingResult result) {

//		Errors errors = new Errors();
//
//		List<ObjectError> allErrors = result.getAllErrors();
//
//		for (ObjectError error : allErrors) {
//
//			if (error instanceof FieldError) {
//
//				errors.addFieldError(((FieldError) error).getField(),
//						error.getDefaultMessage());
//			} else {
//				errors.addObjectError(error.getObjectName(),
//						error.getDefaultMessage());
//			}
//		}

        return null;
    }


}
