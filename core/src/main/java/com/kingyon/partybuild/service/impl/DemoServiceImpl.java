package com.kingyon.partybuild.service.impl;

import com.kingyon.partybuild.domain.DemoBean;
import com.kingyon.partybuild.repositories.DemoRepository;
import com.kingyon.partybuild.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "demoService")
public class DemoServiceImpl implements IDemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Override
    public List<DemoBean> findAll() {
        return demoRepository.findAll();
    }

    @Override
    public Page<DemoBean> pageDemo(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "createdDate");
        Page<DemoBean> pager = demoRepository.findAll(pageable);
        return pager;
    }

    @Override
    public DemoBean findOne(Long id) {
        return demoRepository.findOne(id);
    }

    @Override
    public void save(DemoBean demoBean) {
        demoRepository.save(demoBean);
    }

    @Override
    public void delete(DemoBean demoBean) {
        demoRepository.delete(demoBean);
    }

    @Override
    public List<DemoBean> findDemoBeanByName(String name) {
        return demoRepository.findDemoBeanByName(name);
    }
}
