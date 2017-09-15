package com.kingyon.partybuild.service.personal.impl;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.common.services.impl.BaseService;
import com.kingyon.partybuild.domain.user.User;
import com.kingyon.partybuild.repositories.UserRepository;
import com.kingyon.partybuild.service.personal.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述
 * <p/>
 *
 * @author <a href="Abel@kingyon.com">Abel</a>
 * 2017/9/15
 * @since 0.1.0
 */
@Service(value = "personalService")
@Transactional(readOnly = true)
public class PersonalServiceImpl extends BaseService<User,Long> implements PersonalService {
    @Autowired
    private UserRepository userRepository;
    @Override
    protected CacheRepository<User, Long> getRepository() {
        return userRepository;
    }

    public User findOne(Long user_id){
        return userRepository.findOne(user_id);
    }
}
