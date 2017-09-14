package com.kingyon.partybuild.service.article;

import com.kingyon.common.services.IBaseService;
import com.kingyon.partybuild.domain.learnset.Article;

public interface IArticleService extends IBaseService<Article, Long> {

    /**
     * 支部发布文章
     *
     * @param content   内容
     * @param imageKeys 图片KEY,以逗号分隔,
     * @param title     标题
     * @param type      分类
     * @param uid       当前登录的会员ID
     */
    void partyPublishArticle(String content, String imageKeys, String title, int type, long uid) throws Exception;
}
