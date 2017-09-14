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
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    private RedisTemplate redisTemplate;

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

    /**
     * 注册一个用户
     *
     * @param nickname
     * @param gender
     */
    @Override
    public void register(String nickname, Gender gender) {
        Member member = new Member(nickname, gender);
        memberRepository.save(member);
    }

    /**
     * 用户认证
     *
     * @param mobile
     * @param name
     */
    @Override
    public void updateMobileAndName(MemberModel memberModel, String mobile, String name) {
        Member member = findOne(memberModel.getId());
        if (member != null && !isMobileExists(mobile, member.getId())) {
            member.setMobile(mobile);
            member.setName(name);
            memberRepository.save(member);

            //更新缓存信息
            memberModel.setMobile(mobile);
            memberModel.setNickname(name);
            memberCacheService.put(memberModel);
        }
    }

    @Override
    public boolean isMobileExists(String mobile, Long memberId) {
        MemberQuery query = new MemberQuery();
        query.setMobile(mobile);
        query.setDel(false);
        if (memberId != null) {
            query.setId(memberId);
            return memberRepository.count(query) > 1;
        } else {
            return memberRepository.count(query) > 0;
        }
    }

    @Override
    public MemberModel getMemberById(Long userId) {

        //尝试在缓存获取缓存对象
        MemberModel memberModel = memberCacheService.getById(userId);

        if (memberModel == null) {

            //在没有找到缓存对象的时候,尝试获取数据库信息
            Member member = memberRepository.findOne(userId);

            if (member != null) {

                //获取到数据库对象,并初始化缓存对象
                memberModel = convertMemberToMemberModel(member);

                memberCacheService.put(memberModel);
            }
        }

        return memberModel;
    }

    private MemberModel convertMemberToMemberModel(Member member) {

        MemberModel memberModel = new MemberModel(member);

        return memberModel;
    }

    /**
     * 将用户信息构造为缓存对象并保存
     *
     * @param member
     * @return
     */
    @Override
    public MemberModel putMemberToCache(Member member) {

        if (member != null) {

            MemberModel memberModel = convertMemberToMemberModel(member);

            //添加缓存对象信息
            memberCacheService.put(memberModel);

            return memberModel;
        }

        return null;
    }
}
