package com.kingyon.partybuild.service.home;

import com.kingyon.common.services.IBaseService;
import com.kingyon.partybuild.domain.learnset.Article;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by Machenike on 2017/9/15.
 */
public interface DynamicListService extends IBaseService<Article, Long> {

    List<Article> getDynamicList(Pageable pageable, boolean del);
}
