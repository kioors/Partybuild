package com.kingyon.partybuild.repositories;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.partybuild.domain.member.Member;

/**
 * Created by Administrator on 2017/8/11 0011.
 */
public interface MemberRepository extends CacheRepository<Member, Long> {

    Member findByOpenid(String openId);

    Member findMemberByOpenid(String openid);
}
