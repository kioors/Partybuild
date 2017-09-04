package com.kingyon.partybuild.config;

/**
 * <p>Title:PropsKey</p>
 * <p>Description:系统配置项 keys</p>
 * <p>Company:成都金翼致远科技有限公司</p>
 *
 * @author Jimmy
 * @date 2016-3-16 下午6:07:44
 */
public class PropsKey {

    /**
     * 后台用户附件本地存储路径
     */
    public static final String USER_ATTACHMENT_PATH = "application.user.attachment.path";

    /**
     * 后台用户附件远程访问地址
     */
    public static final String USER_ATTACHMENT_URL = "application.user.attachment.url";

    /**
     * 客户端用户附件本地存储路径
     */
    public static final String MEMBER_ATTACHMENT_PATH = "application.member.attachment.path";

    /**
     * 客户端用户附件远程访问地址
     */
    public static final String MEMBER_ATTACHMENT_URL = "application.member.attachment.url";

    /**
     * 用户账号注册验证码最大有效时间（分钟）
     */
    public static final String SECURITY_CODE_REGISTRY_LIFE_TIME = "application.securityCode.registry.lifeTime";

    /**
     * 用户重置密码验证码最大有效时间（分钟）
     */
    public static final String SECURITY_CODE_REST_PASSWORD_LIFE_TIME = "application.securityCode.restpassword.lifeTime";

    /**
     * 用户账号注册验证码获取时间间隔（秒）
     */
    public static final String SECURITY_CODE_REGISTRY_INTERVAL_TIME = "application.securityCode.registry.interval";

    /**
     * 用户账号注册验证码获取时间间隔（秒）
     */
    public static final String SECURITY_CODE_RSET_PASSWORD_INTERVAL_TIME = "application.securityCode.restpassword.interval";

    /**
     * 用户账号注册验证码长度
     */
    public static final String SECURITY_CODE_REGISTRY_LENGTH = "application.securityCode.registry.length";

    /**
     * 用户注册短信模板
     */
    public static final String USER_REGISTRY_SMS_TEMPLATE = "application.sms.registry.template";

    /**
     * 用户重置密码短信模板
     */
    public static final String USER_REST_PASSWORD_SMS_TEMPLATE = "application.sms.resetpassword.template";

    /**
     * 支付密码短信模板
     */
    public static final String USER_SET_PAY_PASSWORD_SMS_TEMPLATE = "application.sms.set.paypassword.template";

    /**
     * 小图像像素大小
     */
    public static final String IMG_SMALL_SIZE = "application.img.small.size";

    /**
     * 中图像像素大小
     */
    public static final String IMG_MEDIUM_SIZE = "application.img.medium.size";

    /**
     * 大图像像素大小
     */
    public static final String IMG_BIG_SIZE = "application.img.big.size";

    /***************************逻辑层附件信息 begin************************/

    /**
     * 广告附件相关
     */
    public static final String CAR_BRAND_ATTACHMENT_PATH = "application.car.brand.attachment.path";
    public static final String CAR_BRAND_ATTACHMENT_URL = "application.car.brand.attachment.url";

}
