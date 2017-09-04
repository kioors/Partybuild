package com.kingyon.partybuild.service.impl;

import com.kingyon.common.domain.Gender;
import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.common.services.impl.BaseService;
import com.kingyon.partybuild.domain.member.Member;
import com.kingyon.partybuild.model.MemberModel;
import com.kingyon.partybuild.query.MemberQuery;
import com.kingyon.partybuild.repositories.MemberRepository;
import com.kingyon.partybuild.service.IMemberService;
import com.kingyon.partybuild.support.cache.IMemberCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户service
 * <p/>
 *
 * @author <a href="libing@kingyon.com">XiaoDong Yuan</a>
 * 2017/8/11 0011
 * @since 0.1.0
 */
@Service
public class MemberServiceImpl extends BaseService<Member, Long> implements IMemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private IMemberCacheService memberCacheService;

    @Override
    protected CacheRepository<Member, Long> getRepository() {
        return memberRepository;
    }

    /**
     * 添加用户
     *
     * @param member
     */
    @Override
    public void saveMember(Member member) {
        Member temp = findMemberDetail(member);
        if (temp == null) {
            member.setCreatedDate(new Date());
        } else {
            member.setAvatar(temp.getAvatar());
            member.setName(temp.getName());
        }
        save(member);
    }

    /**
     * 修改用户信息
     *
     * @param member
     */
    @Override
    public void updateMember(Member member) {

    }

    /**
     * 查询用户详细信息
     *
     * @param member
     * @return
     */
    @Override
    public Member findMemberDetail(Member member) {
        return findOne(member.getId());
    }

    @Override
    public Member findMemberDetailByOpenid(String openid) {
        return memberRepository.findMemberByOpenid(openid);
    }

    /**
     * 注册一个用户
     *
     * @param openid
     * @param nickname
     * @param gender
     */
    @Override
    public void register(String openid, String nickname, Gender gender) {
        Member member = new Member(openid, nickname, gender);
        memberRepository.save(member);
    }

    /**
     * 用户认证
     *
     * @param mobile
     * @param name
     */
    @Override
    public void updateMobileAndName(Long userId, String mobile, String name) {
        Member member = findOne(userId);
        if (member != null && !isMobileExists(mobile, member.getId())) {
            member.setMobile(mobile);
            member.setName(name);
            memberRepository.save(member);
        }
    }

    @Override
    public boolean isMobileExists(String mobile, Long memberId) {
        MemberQuery query = new MemberQuery();
        query.setMobile(mobile);
        if (memberId != null) {
            query.setId(memberId);
            return memberRepository.count(query) > 1;
        } else {
            return memberRepository.count(query) > 0;
        }
    }

    @Override
    public MemberModel getMemberById(Long userId) {

        MemberModel memberModel = memberCacheService.getById(userId);

        if (memberModel == null) {

            Member member = memberRepository.findOne(userId);

            if (member != null) {

                memberModel = convertMemberToMemberModel(member);
            }
        }

        return memberModel;
    }

    private MemberModel convertMemberToMemberModel(Member member) {

        MemberModel memberModel = new MemberModel(member);

        return memberModel;
    }

    @Override
    public MemberModel getMemberByOpenId(String openId) {

        Member member = memberRepository.findByOpenid(openId);

        if (member != null) {

            return convertMemberToMemberModel(member);
        }

        return null;
    }
}
