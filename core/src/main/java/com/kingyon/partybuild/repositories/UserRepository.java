package com.kingyon.partybuild.repositories;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.partybuild.domain.user.User;
import org.springframework.data.jpa.repository.Query;

/**
 * @author <a href="black@kingyon.com">Runyu Wang</a>
 * 2017/8/14
 * @since 0.1.0
 */
public interface UserRepository extends CacheRepository<User, Long> {
    /**
     * 通过Mobile查询后台用户
     *
     * @param mobile
     * @return user
     */
    @Query(value = "select u from User u where u.deleted = false and u.mobile = ?1")
    User findUserByMobile(String mobile);
}
