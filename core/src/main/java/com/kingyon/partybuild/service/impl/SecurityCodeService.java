package com.kingyon.partybuild.service.impl;

import com.kingyon.partybuild.domain.SecurityCode;
import com.kingyon.partybuild.service.ISecurityCodeService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


/**
 * <p>Title:SecurityCodeService</p>
 * <p>Description:验证码管理服务接口</p>
 * <p>Company:成都金翼致远科技有限公司</p>
 *
 * @author Jimmy
 * @date 2016-5-3 下午6:42:03
 */
@Service
public class SecurityCodeService implements ISecurityCodeService {

    @Autowired
    private RedisTemplate<String, SecurityCode> redisTemplate;

    private int securityCodeLength = 6;

    /**
     * (non-Javadoc)
     */
    @Override
    public boolean contains(String ownner, String type) {

        String hashKey = buildKey(ownner, type);

        return redisTemplate.hasKey(hashKey);


    }

    @Override
    public SecurityCode generate(String ownner, String type, int minutes) {

        String hashKey = buildKey(ownner, type);

        long now = System.currentTimeMillis();

        String securityCodeValue = RandomStringUtils.randomNumeric(securityCodeLength);
        SecurityCode securityCode = new SecurityCode();
        securityCode.setCreateTime(now);
        securityCode.setValue(securityCodeValue);
        if (minutes > 0) {
            securityCode.setExpireTime(now + 3600000L * (long) minutes);
        }
        redisTemplate.boundValueOps(hashKey).set(securityCode, minutes, TimeUnit.MINUTES);

        return securityCode;

    }

    /**
     * (non-Javadoc)
     */
    @Override
    public SecurityCode get(String ownner, String type) {
        String hashKey = buildKey(ownner, type);
        return redisTemplate.boundValueOps(hashKey).get();

    }

    /**
     * (non-Javadoc)
     */
    @Override
    public void delete(String ownner, String type) {
        String hashKey = buildKey(ownner, type);
        redisTemplate.delete(hashKey);
    }

    protected String buildKey(String ownner, String type) {
        String hashKey = "securityCode:" + type + ":" + ownner;
        return hashKey;
    }

    /**
     * @author shichuan
     * 针对验证码和修改密码之类操作分开提交的场景,增加校验标示
     */
    @Override
    public void addFlag(String owner, String type) {
        String hashKey = buildFlagKey(owner, type);
        SecurityCode securityCode = new SecurityCode();
        //10分钟有效
        redisTemplate.boundValueOps(hashKey).set(securityCode, 10, TimeUnit.MINUTES);
    }

    /**
     * @author shichuan
     * 针对验证码和修改密码之类操作分开提交的场景,获取校验标示
     */
    @Override
    public boolean existsFlag(String owner, String type) {
        String hashKey = buildFlagKey(owner, type);
        return redisTemplate.boundValueOps(hashKey).get() != null;
    }

    /**
     * @author shichuan
     * 手动删除校验标示
     */
    @Override
    public void deleteFlag(String owner, String type) {
        String hashKey = buildFlagKey(owner, type);
        redisTemplate.delete(hashKey);
    }

    /**
     * @author shichuan
     * 构造校验标示key
     */
    private String buildFlagKey(String owner, String type) {
        String hashKey = "securityCode:flag:" + type + ":" + owner;
        return hashKey;
    }


    /**
     * @param redisTemplate the redisTemplate to set
     */
    public void setRedisTemplate(RedisTemplate<String, SecurityCode> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * @param securityCodeLength the securityCodeLength to set
     */
    public void setSecurityCodeLength(int securityCodeLength) {
        this.securityCodeLength = securityCodeLength;
    }
}
