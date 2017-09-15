package com.kingyon.partybuild.service.home.impl;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.common.services.impl.BaseService;
import com.kingyon.partybuild.domain.learnset.Article;
import com.kingyon.partybuild.service.home.DynamicListService;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by Machenike on 2017/9/15.
 */
public class DynamicListServiceImpl extends BaseService<Article, Long> implements DynamicListService {

    @Override
    protected CacheRepository<Article, Long> getRepository() {
        return null;
    }

    @Override
    public List<Article> getDynamicList(Pageable pageable, boolean del) {
        return null;
    }
}
