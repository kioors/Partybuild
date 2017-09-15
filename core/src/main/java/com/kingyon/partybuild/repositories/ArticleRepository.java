package com.kingyon.partybuild.repositories;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.partybuild.domain.learnset.Article;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface ArticleRepository extends CacheRepository<Article, Long> {

    @Query("select a from Article a")
    public List<Article> getArticle(Pageable pageable, boolean del);

}
