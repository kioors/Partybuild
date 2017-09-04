package com.kingyon.partybuild.domain;

import java.io.Serializable;

/**
 * <p>Title:SecurityCode</p>
 * <p>Description:验证码</p>
 * <p>Company:成都金翼致远科技有限公司</p>
 *
 * @author Jimmy
 * 2016-5-23 下午4:43:19
 */
public class SecurityCode implements Serializable {


    private static final long serialVersionUID = -1760028764901345232L;

    /**
     * 验证码字符
     */
    private String value;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 过期时间，为null则表示不限有效时间
     */
    private Long expireTime;

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the createTime
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the expireTime
     */
    public Long getExpireTime() {
        return expireTime;
    }

    /**
     * @param expireTime the expireTime to set
     */
    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public boolean isExpred() {

        if (expireTime == null) {

            return false;
        }

        return System.currentTimeMillis() - expireTime.longValue() > 0;
    }
}
