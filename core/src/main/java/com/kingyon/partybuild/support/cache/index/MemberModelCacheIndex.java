package com.kingyon.partybuild.support.cache.index;

import java.io.Serializable;

/**
 * describe: 用户缓存实现类
 *
 * @author <a href="sam@kingyon.com">Yang Xiang</a>
 * 2017/7/17 14:01
 * @since 0.1.0
 */
public class MemberModelCacheIndex implements Serializable {
    private static final long serialVersionUID = 7421443060481803684L;

    private String username;

    private String email;

    private String mobile;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


}
