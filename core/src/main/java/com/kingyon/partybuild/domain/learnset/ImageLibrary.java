package com.kingyon.partybuild.domain.learnset;

import com.kingyon.common.domain.AuditedDomain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 图片管理
 */
@Entity
@Table(name = "S_IMAGE_LIBRARY")
public class ImageLibrary extends AuditedDomain {

    /**
     * Default constructor
     */
    public ImageLibrary() {
    }

    /**
     *
     */
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    private LoopImages loopImages;

    /**
     * 1文章图，2首页轮播图
     */
    private ImageType type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageType getType() {
        return type;
    }

    public void setType(ImageType type) {
        this.type = type;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public LoopImages getLoopImages() {
        return loopImages;
    }

    public void setLoopImages(LoopImages loopImages) {
        this.loopImages = loopImages;
    }
}