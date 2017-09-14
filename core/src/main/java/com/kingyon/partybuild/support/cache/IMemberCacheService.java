package com.kingyon.partybuild.support.cache;


import com.kingyon.partybuild.model.MemberModel;

/**
 * describe: 用户缓存
 *
 * @author <a href="sam@kingyon.com">Yang Xiang</a>
 * 2017/7/17 14:00
 * @since 0.1.0
 */
public interface IMemberCacheService {

    public void put(MemberModel userModel);

    public void deleteById(Long id);

    public MemberModel getById(Long id);

    public MemberModel getByUsername(String username);

    public MemberModel getByEmail(String email);

    public MemberModel getByMobile(String mobile);

    public void clear();
}
