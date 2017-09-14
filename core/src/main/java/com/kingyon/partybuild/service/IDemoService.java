package com.kingyon.partybuild.service;


import com.kingyon.common.domain.authorization.Role;
import com.kingyon.partybuild.domain.DemoBean;
import com.kingyon.partybuild.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface IDemoService {

    List<DemoBean> findAll();

    Page<DemoBean> pageDemo(Integer page, Integer size);

    DemoBean findOne(Long id);

    void save(DemoBean demoBean);

    void delete(DemoBean demoBean);

    List<DemoBean> findDemoBeanByName(String name);

}
