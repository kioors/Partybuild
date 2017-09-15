package com.kingyon.partybuild.service.home.impl;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.common.services.impl.BaseService;
import com.kingyon.partybuild.domain.learnset.Article;
import com.kingyon.partybuild.service.home.StudyService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Machenike on 2017/9/15.
 */
@Service
public class StudyServiceImpl extends BaseService<Article, Long> implements StudyService {

    @Override
    public List<Article> getArticles() {
        return null;
    }

    @Override
    protected CacheRepository<Article, Long> getRepository() {
        return null;
    }
}
