package com.kingyon.partybuild.service.article.impl;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.common.services.impl.BaseService;
import com.kingyon.partybuild.common.NullParamException;
import com.kingyon.partybuild.domain.learnset.*;
import com.kingyon.partybuild.repositories.ArticleRepository;
import com.kingyon.partybuild.repositories.ImageLibraryRepository;
import com.kingyon.partybuild.service.article.IArticleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service(value = "articleService")
@Transactional(readOnly = true)
public class ArticleService extends BaseService<Article, Long> implements IArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ImageLibraryRepository imageLibraryRepository;

    @Override
    protected CacheRepository<Article, Long> getRepository() {
        return articleRepository;
    }

    @Override
    public void partyPublishArticle(String content, String imageKeys, String title, int type, long uid) throws Exception {
        // content 和 title 为必填参数,
        if (StringUtils.isEmpty(content) || StringUtils.isEmpty(title)) {
            throw new NullParamException();
        }
        // 图片分类也必须存在; 这里存在疑问(熟悉需求的时候,说的是动态的,但是ArticleType又是写死的几个文章分类)
        if (ArticleType.getArticleType(type) == null) {
            throw new NullParamException();
        }

        // 创建并保存Article对象
        Article article = new Article();
        article.setCreateAccountId(uid);
        article.setCreatedDate(new Date());
        article.setDeleted(false);
        article.setEnable(true);
        article.setCollection(0);
        article.setContent(content);
        article.setPageView(0);
        article.setThumbUp(0);
        article.setStatus(StatusType.CHECKING);
        article.setType(ArticleType.getArticleType(type));
        article.setSpecial(false);
        article.setParentId(0L);
        articleRepository.save(article);

        // 文章信息保存后,判断图片key是否为NULL,如果不为NULL,则往数据库添加key
        if (StringUtils.isNotEmpty(imageKeys)) {
            String[] keys = imageKeys.split(",");
            for (String img : keys) {
                ImageLibrary lib = new ImageLibrary();
                lib.setType(ImageType.ARTICLE);
                // 按猜想,这里需要把图片的key转换成图片,放到服务器中,并拿到图片的URL地址存在数据库中
                lib.setUrl("------------------------------");
                lib.setArticle(article);
                imageLibraryRepository.save(lib);
            }
        }
        // article.setHeadImage(null); // 这里等待确认,是否从imageKeys将第一张图片取出来做为封面图
    }
}
