package com.kingyon.web.utils;

import com.kingyon.common.domain.account.Login;
import com.kingyon.common.exception.UserDoesNotExistException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Security utils
 * <p/>
 *
 * @author <a href="libing@kingyon.com">Libing Huang</a>
 * 2017/8/16 下午5:41
 * @since 0.1.0
 */
public class SecurityUtils {

    public static Login getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return (Login) principal;
        }
        throw new UserDoesNotExistException();
    }

}
