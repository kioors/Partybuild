package com.kingyon.partybuild.service.home;

import com.kingyon.common.services.IBaseService;
import com.kingyon.partybuild.domain.learnset.Article;

import java.util.List;

/**
 * Created by Machenike on 2017/9/15.
 */
public interface StudyService extends IBaseService<Article, Long> {

    /**
     * 学习讲话
     *
     * @return 文章列表
     */
    List<Article> getArticles();


}
