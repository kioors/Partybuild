package com.kingyon.partybuild.support.cache.impl;

import com.kingyon.common.cache.ObjectCacheService;
import com.kingyon.partybuild.domain.member.Member;
import com.kingyon.partybuild.model.MemberModel;
import com.kingyon.partybuild.support.cache.IMemberCacheService;
import com.kingyon.partybuild.support.cache.index.MemberModelCacheIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * describe: 用户缓存实现类
 *
 * @author <a href="sam@kingyon.com">Yang Xiang</a>
 * 2017/7/17 14:02
 * @since 0.1.0
 */
@Component
public class MemberCacheService extends ObjectCacheService<Member> implements IMemberCacheService {

    @Autowired
    private RedisTemplate<String, MemberModel> redisTemplate;

    private String usernamePrefix = "username:";

    private String emailPrefix = "email:";

    private String mobilePrefix = "mobile:";

    protected String buildUsernameIndexKey(String username) {

        return usernamePrefix + username;
    }

    protected String buildEmailIndexKey(String email) {

        return emailPrefix + email;
    }

    protected String buildMobileIndexKey(String mobile) {

        return mobilePrefix + mobile;
    }

    @Override
    public void put(MemberModel userModel) {

        dropIndexes(userModel.getId());

        putRecord(userModel);

        createIndexs(userModel);
    }

    @Override
    public MemberModel getById(Long id) {

        return getRecord(id);
    }

    @Override
    public MemberModel getByUsername(String username) {

        Long userId = (Long) redisTemplate.boundHashOps(indexMobule).get(buildUsernameIndexKey(username));

        if (userId != null) {

            return getById(userId);
        }

        return null;
    }

    @Override
    public MemberModel getByEmail(String email) {

        Long userId = (Long) redisTemplate.boundHashOps(indexMobule).get(buildEmailIndexKey(email));

        if (userId != null) {

            return getById(userId);
        }

        return null;
    }

    @Override
    public MemberModel getByMobile(String mobile) {

        Long userId = (Long) redisTemplate.boundHashOps(indexMobule).get(buildMobileIndexKey(mobile));

        if (userId != null) {

            return getById(userId);
        }

        return null;
    }

    protected MemberModel getRecord(Long id) {
        return (MemberModel) redisTemplate.boundHashOps(cacheModule).get(id);
    }

    protected void putRecord(MemberModel userModel) {

        BoundHashOperations<String, Object, Object> cacheMap = redisTemplate.boundHashOps(cacheModule);

        cacheMap.put(userModel.getId(), userModel);
    }

    protected void dropRecord(Long id) {

        redisTemplate.boundHashOps(cacheModule).delete(id);
    }

    protected void createIndexs(MemberModel userModel) {

        Map<String, Object> indexs = new HashMap<String, Object>();

        String username = userModel.getUsername();

        MemberModelCacheIndex userModelCacheIndex = new MemberModelCacheIndex();

        if (username != null) {

            String usernameIndex = buildUsernameIndexKey(username);

            indexs.put(usernameIndex, userModel.getId());

            userModelCacheIndex.setUsername(usernameIndex);
        }

        String mobile = userModel.getMobile();

        if (mobile != null) {
            String mobileIndex = buildMobileIndexKey(mobile);
            indexs.put(mobileIndex, userModel.getId());
            userModelCacheIndex.setMobile(mobileIndex);
        }
        BoundHashOperations<String, Object, Object> indexMap = redisTemplate.boundHashOps(indexMobule);

        indexMap.putAll(indexs);

        redisTemplate.boundHashOps(indexReverseModule).put(userModel.getId(), userModelCacheIndex);
    }

    protected void dropIndexes(Long id) {

        MemberModelCacheIndex userModelCacheIndex = (MemberModelCacheIndex) redisTemplate.boundHashOps(indexReverseModule).get(id);

        if (userModelCacheIndex != null) {

            List<String> deletedIndexKeys = new ArrayList<String>();

            String email = userModelCacheIndex.getEmail();

            if (email != null) {

                deletedIndexKeys.add(email);
            }

            String username = userModelCacheIndex.getUsername();

            if (username != null) {

                deletedIndexKeys.add(username);
            }

            String mobile = userModelCacheIndex.getMobile();
            if (mobile != null) {

                deletedIndexKeys.add(mobile);
            }

            BoundHashOperations<String, Object, Object> indexMap = redisTemplate.boundHashOps(indexMobule);
            if (deletedIndexKeys.size() > 0) {

                indexMap.delete(deletedIndexKeys.toArray());
            }

            redisTemplate.boundHashOps(indexReverseModule).delete(id);
        }
    }

    @Override
    public void deleteById(Long id) {

        dropRecord(id);

        dropIndexes(id);

    }

    @Override
    public void clear() {

        redisTemplate.delete(Arrays.asList(indexMobule, indexMobule, indexReverseModule));
    }
}
