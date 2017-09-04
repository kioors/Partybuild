package com.kingyon.partybuild.service;

import com.kingyon.common.domain.Gender;
import com.kingyon.common.services.IBaseService;
import com.kingyon.partybuild.domain.member.Member;
import com.kingyon.partybuild.model.MemberModel;

/**
 * @author <a href="sam@kingyon.com">Yang Xiang</a>
 * 2017/8/23 上午 10:29:36
 * @since 0.1.0
 */
public interface IMemberService extends IBaseService<Member, Long> {

    /**
     * 添加用户
     *
     * @param member
     */
    void saveMember(Member member);

    /**
     * 修改用户
     *
     * @param member
     */
    void updateMember(Member member);

    /**
     * 查询用户详细信息
     *
     * @param member
     * @return
     */
    Member findMemberDetail(Member member);

    /**
     * 根据微信uid查询用户详细信息
     *
     * @param openid
     * @return
     */
    Member findMemberDetailByOpenid(String openid);

    /**
     * 注册一个用户
     *
     * @param openid
     * @param nickname
     * @param gender
     */
    void register(String openid, String nickname, Gender gender);

    /**
     * 用户认证
     *
     * @param mobile
     * @param name
     */
    void updateMobileAndName(Long id, String mobile, String name);

    /**
     * 判断手机号码是否被注册
     *
     * @param mobile   待验证的手机号码
     * @param memberId 待排除的会员id
     * @return
     */
    boolean isMobileExists(String mobile, Long memberId);

    /**
     * 通过id查找用户
     *
     * @param userId
     * @return
     */
    MemberModel getMemberById(Long userId);

    /**
     * 用过openid查找用户
     *
     * @param openId
     * @return
     */
    MemberModel getMemberByOpenId(String openId);
}
