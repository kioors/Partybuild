package com.kingyon.partybuild.service;


import com.kingyon.common.services.IBaseService;
import com.kingyon.partybuild.domain.DemoBean;
import org.springframework.data.domain.Page;

import java.util.List;


public interface IDemoService extends IBaseService<DemoBean, Long> {

    List<DemoBean> findAll();

    Page<DemoBean> pageDemo(Integer page, Integer size);

    DemoBean findOne(Long id);

    DemoBean save(DemoBean demoBean);

    void delete(DemoBean demoBean);

    List<DemoBean> findDemoBeanByName(String name);

}
