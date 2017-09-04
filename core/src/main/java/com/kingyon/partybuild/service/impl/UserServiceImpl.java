package com.kingyon.partybuild.service.impl;

import com.kingyon.common.domain.authorization.Role;
import com.kingyon.partybuild.domain.user.User;
import com.kingyon.partybuild.query.UserQuery;
import com.kingyon.partybuild.repositories.UserRepository;
import com.kingyon.partybuild.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ${DESCRIPTION}
 * <p/>
 *
 * @author <a href="libing@kingyon.com">Libing Huang</a>
 * 2017/8/8 下午2:28
 * @since 0.1.0
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
        return userRepository.findUserByMobile(mobile);
    }

    /**
     * 添加内部用户
     *
     * @param name
     * @param mobile
     * @param password
     */
    @Override
    public void createUser(String name, String mobile, String password) {
        User user = new User(name, mobile);
        String encodePassword = passwordEncoder.encodePassword(password, mobile);
        user.setPassword(encodePassword);
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public Page<User> pageUser(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "createdDate");
        Page<User> pager = userRepository.findAll(pageable);
        return pager;
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> findUserByRole(Role role) {
        User user = new User();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        UserQuery userQuery = new UserQuery();
        userQuery.setUser(user);
        List<User> users = userRepository.findAll(userQuery);
        return users;
    }

    @Override
    public User findUserByMobile(String mobile) {

        return userRepository.findUserByMobile(mobile);
    }


}
