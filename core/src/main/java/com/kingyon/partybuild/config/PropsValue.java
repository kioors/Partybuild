package com.kingyon.partybuild.config;

/**
 * <p>
 * Title:PropsValue
 * </p>
 * <p>
 * Description:系统配置项 values
 * </p>
 * <p>
 * Company:成都金翼致远科技有限公司
 * </p>
 *
 * @author Jimmy
 * @date 2016-3-16 下午6:08:08
 */
public class PropsValue {

    /**
     * 后台用户附件本地存储路径
     */
    public static final String USER_ATTACHMENT_PATH = Props.getString(
            PropsKey.USER_ATTACHMENT_PATH, System.getProperty("personal.dir"));

    /**
     * 后台用户附件远程访问地址
     */
    public static final String USER_ATTACHMENT_URL = Props.getString(
            PropsKey.USER_ATTACHMENT_URL, "http://127.0.0.1/personal");

    /**
     * 客户端用户附件本地存储路径
     */
    public static final String MEMBER_ATTACHMENT_PATH = Props.getString(
            PropsKey.MEMBER_ATTACHMENT_PATH, System.getProperty("personal.dir"));

    /**
     * 客户端用户附件远程访问地址
     */
    public static final String MEMBER_ATTACHMENT_URL = Props.getString(
            PropsKey.MEMBER_ATTACHMENT_URL, "http://127.0.0.1/personal");

    /**
     * 用户账号注册验证码最大有效时间（分钟）
     */
    public static final int SECURITY_CODE_REGISTRY_LIFE_TIME = Props.getInt(
            PropsKey.SECURITY_CODE_REGISTRY_LIFE_TIME, 5);

    /**
     * 用户重置密码验证码最大有效时间（分钟）
     */
    public static final int SECURITY_CODE_REST_PASSWORD_LIFE_TIME = Props
            .getInt(PropsKey.SECURITY_CODE_REST_PASSWORD_LIFE_TIME, 5);

    /**
     * 用户重置密碼发送间隔时间（秒）
     */
    public static final int SECURITY_CODE_RSET_PASSWORD_INTERVAL_TIME = Props
            .getInt(PropsKey.SECURITY_CODE_RSET_PASSWORD_INTERVAL_TIME, 60);

    /**
     * 用户账号注册验证码发送间隔时间（秒）
     */
    public static final int SECURITY_CODE_REGISTRY_INTERVAL_TIME = Props
            .getInt(PropsKey.SECURITY_CODE_REGISTRY_INTERVAL_TIME, 60);

    /**
     * 用户账号注册验证码长度
     */
    public static final int SECURITY_CODE_REGISTRY_LENGTH = Props.getInt(
            PropsKey.SECURITY_CODE_REGISTRY_LENGTH, 6);

    /**
     * 小图
     */
    public static final int IMG_SMALL_SIZE = Props.getInt(PropsKey.IMG_SMALL_SIZE, 240);

    /**
     * 中图
     */
    public static final int IMG_MEDIUM_SIZE = Props.getInt(PropsKey.IMG_MEDIUM_SIZE, 480);

    /**
     * 大图
     */
    public static final int IMG_BIG_SIZE = Props.getInt(PropsKey.IMG_BIG_SIZE, 800);

    /***************************逻辑层附件信息 begin************************/

    /**
     * 广告附件
     */
    public static final String CAR_BRAND_ATTACHMENT_PATH = Props.getString(PropsKey.CAR_BRAND_ATTACHMENT_PATH, "");
    public static final String CAR_BRAND_ATTACHMENT_URL = Props.getString(PropsKey.CAR_BRAND_ATTACHMENT_URL, "");
}

