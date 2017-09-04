package com.kingyon.partybuild.service;


import com.kingyon.partybuild.domain.SecurityCode;

/**
 * <p>Title:ISecurityCodeService</p>
 * <p>Description:</p>
 * <p>Company:成都金翼致远科技有限公司</p>
 *
 * @author Jimmy
 * 2016-5-3 下午6:39:55
 */
public interface ISecurityCodeService {

    /**
     * 判断目标是否生成了指定类型的验证码，并且尚未过期
     *
     * @param ownner 目标
     * @param type   验证码类型
     * @return boolean 是否生成并且商未过期
     * @author Jimmy
     * 2016-3-17
     */
    boolean contains(String ownner, String type);

    /**
     * 为目标生成指定类型的验证码
     *
     * @param ownner  目标
     * @param type    验证码类型
     * @param minutes 有效时间（分钟）
     * @return SecurityCode 生成的验证码
     * @author Jimmy
     * 2016-3-17
     */
    SecurityCode generate(String ownner, String type, int minutes);

    /**
     * 获取目标生成的验证码（如果未生成或已经过期，会返回null）
     *
     * @param ownner 目标
     * @param type   验证码类型
     * @return SecurityCode 生成的验证码
     * @author Jimmy
     * 2016-3-17
     */
    SecurityCode get(String ownner, String type);

    /**
     * 删除目标生成的验证码
     *
     * @param ownner 目标
     * @param type   验证码类型
     * @author Jimmy
     * 2016-3-17
     */
    void delete(String ownner, String type);

    /**
     * @author shichuan
     * 针对验证码和修改密码之类操作分开提交的场景,增加校验标示
     */
    void addFlag(String owner, String type);

    /**
     * @author shichuan
     * 针对验证码和修改密码之类操作分开提交的场景,获取校验标示
     */
    boolean existsFlag(String owner, String type);

    /**
     * @author shichuan
     * 手动删除校验标示
     */
    void deleteFlag(String owner, String type);
}
