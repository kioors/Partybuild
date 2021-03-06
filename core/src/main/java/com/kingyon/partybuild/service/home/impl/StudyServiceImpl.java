package com.kingyon.partybuild.service.home.impl;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.common.services.impl.BaseService;
import com.kingyon.partybuild.domain.learnset.Article;
import com.kingyon.partybuild.repositories.ArticleRepository;
import com.kingyon.partybuild.service.home.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by Machenike on 2017/9/15.
 */
@Service
public class StudyServiceImpl extends BaseService<Article, Long> implements StudyService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    protected CacheRepository<Article, Long> getRepository() {
        return null;
    }

    @Override
    public List<Article> getArticles(Pageable pageable, boolean del) {
        return null;
    }
}
