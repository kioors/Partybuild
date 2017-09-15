package com.kingyon.partybuild.repositories;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.partybuild.domain.learnset.Article;

/**
 * Created by Machenike on 2017/9/15.
 */
public interface DynamicListRepository extends CacheRepository<Article, Long> {
}
