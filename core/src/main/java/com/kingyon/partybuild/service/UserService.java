package com.kingyon.partybuild.service;


import com.kingyon.common.domain.authorization.Role;
import com.kingyon.partybuild.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * 用户登入登出相关操作
 * <p/>
 *
 * @author sam
 * @author <a href="libing@kingyon.com">Libing Huang</a>
 * 2017/8/8 上午10:42
 * @since 0.1.0
 */
public interface UserService extends UserDetailsService {

    /**
     * 添加内部用户
     *
     * @param name
     * @param mobile
     * @param password
     */
    void createUser(String name, String mobile, String password);

    /**
     * 查找所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 查找所有用户分页
     *
     * @return
     */
    Page<User> pageUser(Integer page, Integer size);

    /**
     * 通过id查找单个用户
     *
     * @param id
     * @return
     */
    User findOne(Long id);

    /**
     * 保存user
     *
     * @param user
     */
    void save(User user);

    /**
     * 删除用户
     *
     * @param user
     */
    void delUser(User user);

    /**
     * 通过Role查询用户
     *
     * @param role
     * @return
     */
    List<User> findUserByRole(Role role);

    User findUserByMobile(String mobile);



}
