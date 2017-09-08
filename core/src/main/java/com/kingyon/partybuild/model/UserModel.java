package com.kingyon.partybuild.model;

import com.kingyon.common.model.AccountModel;

/**
 * describe：前端用户类
 *
 * @author <a href="sam@kingyon.com">Yang Xiang</a>
 * 2017/7/17 13:38
 * @since 0.1.0
 */
public class UserModel extends AccountModel {

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;
    /**
     * name
     */
    private String name;

    public UserModel() {
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
