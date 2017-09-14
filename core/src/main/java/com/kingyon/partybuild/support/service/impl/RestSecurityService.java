package com.kingyon.partybuild.support.service.impl;

import com.kingyon.common.support.util.StringPool;
import com.kingyon.partybuild.model.MemberModel;
import com.kingyon.partybuild.service.IMemberService;
import com.kingyon.partybuild.support.service.IRestSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * describe: 用户接口
 * @author <a href="sam@kingyon.com">Yang Xiang</a>
 *         2017/8/23 上午 10:27:28
 * @since 0.1.0
 */
@Service
public class RestSecurityService implements IRestSecurityService {

    public static final int OVERDUE_TIME = 7;

    @Autowired
    private IMemberService memberService;

    private static final String ACCOUNT_KEY_PREFIX = "TOKEN ";//access token redis key前缀

    private String buildAccountKey(Long accountId, String token) {

        return ACCOUNT_KEY_PREFIX + accountId + StringPool.SLASH + token;
    }

    private String buildAccountKeyPatternByToken(String token) {

        token = token.substring(token.lastIndexOf("/") + 1);

        return ACCOUNT_KEY_PREFIX + StringPool.STAR + StringPool.SLASH + token;
    }

    private String buildAccountKeyPatternById(Long id) {

        return ACCOUNT_KEY_PREFIX + id + StringPool.SLASH + StringPool.STAR;
    }
    @Autowired
    private RedisTemplate<String, Long> redisTemplate;

    @Override
    public String login(Long id) {

        //登出
        logout(id);

        //用户token
        String token = UUID.randomUUID().toString();

        //用户的key
        String key = buildAccountKey(id, token);

        //保存用户的id
        redisTemplate.boundValueOps(key).set(id);

        //设置过期时间
        setTimeout(key);

        return key;
    }

    @Override
    public void logout(String token) {

        String pattern = buildAccountKeyPatternByToken(token);

        Set<String> keys = redisTemplate.keys(pattern);

        if (keys != null && !keys.isEmpty()) {

            redisTemplate.delete(keys);
        }
    }

    @Override
    public void logout(Long id) {

        String pattern = buildAccountKeyPatternById(id);

        Set<String> keys = redisTemplate.keys(pattern);

        if (keys != null && !keys.isEmpty()) {

            redisTemplate.delete(keys);
        }
    }

    @Override
    public MemberModel getUserByToken(String token) {

        Long userId = redisTemplate.boundValueOps(token).get();

        if (userId != null) {

            setTimeout(token);

            return memberService.getMemberById(userId);
        }
        return null;
    }

    @Override
    public Long getUserIdByToken(String token) {

        Long userId = redisTemplate.boundValueOps(token).get();

        setTimeout(token);

        return userId;
    }

    private void setTimeout(String token) {

        redisTemplate.boundValueOps(token).expire(OVERDUE_TIME, TimeUnit.DAYS);//一周过期
    }

}
