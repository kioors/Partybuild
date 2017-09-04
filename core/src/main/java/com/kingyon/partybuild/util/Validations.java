package com.kingyon.partybuild.util;

import java.util.regex.Pattern;

/**
 * <p>Title:Validations</p>
 * <p>Description:</p>
 * <p>Company:成都金翼致远科技有限公司</p>
 *
 * @author Jimmy
 * @date 2016-5-3 下午5:30:57
 */
public class Validations {

    /**
     * 手机号码验证正则表达式
     */
    //public static final String MOBILE_REGEX="^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
    public static final String MOBILE_REGEX = "^1[3|4|5|7|8]\\d{9}$";
    /**
     * 手机号码验证正则表达式验证错误消息
     */
    public static final String MOBILE_REGEX_MESSAGE = "您所输入的手机号码格式不正确";

    /**
     * 用户名验证正则表达式
     */
    public static final String USERNAME_REGEX = "^[a-zA-z][a-zA-Z0-9_]{2,17}$";

    /**
     * 用户名验证正则表达式 错误消息
     */
    public static final String USERNAME_REGEX_MESSAGE = "用户账号只能由字母与数字组成，并且只能以字母开头,长度必须在3~16个字符之间";

    /**
     * 密码验证正则表达式
     */
    public static final String PASSWORD_REGEX = "^(?![0-9]+$)(?![a-zA-Z]+$)(?!([^(0-9a-zA-Z)]|[\\(\\)])+$)([^(0-9a-zA-Z)]|[\\(\\)]|[a-zA-Z]|[0-9]){6,32}$";

    /**
     * 密码验证正则表达式  错误消息
     */
    public static final String PASSWORD_REGEX_MESSAGE = "登录密码必须在6~32位数之间，并且必须由字母、数字和符号两种以上组合。";

    /**
     * 支付密码正则表达式
     */
    public static final String PAY_PASSWORD_REGEX = "\\d{6}";

    /**
     * 支付密码验证正则表达式  错误消息
     */
    public static final String PAY_PASSWORD_REGEX_MESSAGE = "支付密码必须是6位数的数字";

    /**
     * 邮编正则表达式
     */
    public static final String ZIP_CODE_REGEX = "^[1-9]\\d{5}$";

    /**
     * 邮编验证正则表达式  错误消息
     */
    public static final String ZIP_CODE_REGEX_MESSAGE = "您输入的邮政编码格式不正确";


    /**
     * @param mobile 手机号码
     * @return boolean 是否为有效的手机号码
     * @Description: 判断输入字符串是否是一个有效的手机号码格式
     * @author Jimmy
     * @date 2016-3-17
     */
    public static boolean isMobile(String mobile) {

        return Pattern.matches(MOBILE_REGEX, mobile);
    }

    /**
     * @param username 用户名
     * @return boolean 是否为有效的用户名格式
     * @Description: 判断输入字符串是否是一个有效的用户名格式
     * @author Jimmy
     * @date 2016-3-17
     */
    public static boolean isUsername(String username) {

        return Pattern.matches(USERNAME_REGEX, username);
    }

    /**
     * @param password 密码
     * @return boolean 是否为有效的密码格式
     * @Description: 判读输入字符串是否是一个有效的密码格式
     * @author Jimmy
     * @date 2016-3-17
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(PASSWORD_REGEX, password);
    }

    /**
     * @param zipCode 邮编
     * @return boolean 是否是一个有效的邮政编码
     * @Description: 判断输入字符串是否是一个有效的邮政编码
     * @author Jimmy
     * @date 2016-5-18
     */
    public static boolean isZipCode(String zipCode) {

        return Pattern.matches(ZIP_CODE_REGEX, zipCode);
    }
}
