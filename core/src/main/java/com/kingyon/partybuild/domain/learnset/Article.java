package com.kingyon.partybuild.domain.learnset;


import com.kingyon.common.domain.AuditedDomain;

import javax.persistence.*;
import java.util.List;

/**
 * 文章
 */
@Entity
@Table(name = "S_ARTICLE")
public class Article extends AuditedDomain {

    /**
     * Default constructor
     */
    public Article() {
    }

    /**
     *
     */
    public String title;

    /**
     * 收藏量
     */
    public Integer collection = 0;

    /**
     * 浏览量
     */
    @Column(name = "page_view")
    public Integer pageView = 0;

    /**
     * 点赞量
     */
    @Column(name = "thumb_up")
    public Integer thumbUp = 0;

    /**
     *
     */
    public String content;

    /**
     * 0审核中，1已通过，2未通过
     */
    public StatusType status;

    /**
     * 1通知公告，2党团计划，3党务公开
     */
    public ArticleType type;

    /**
     * 文章图片
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article", cascade = CascadeType.ALL)
    public List<ImageLibrary> imglist;

    /**
     * 拒绝原因
     */
    @Column(name = "refuse_reason")
    public String refuseReason;

    /**
     * 是否为专题：0不是，1是
     */
    @Column(name = "is_special")
    public Boolean isSpecial;

    /**
     *
     */
    @Column(name = "parent_id")
    public Long parentId;

    /**
     * 封面图
     */
    @Column(name = "head_image")
    public String headImage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCollection() {
        return collection;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    public Integer getThumbUp() {
        return thumbUp;
    }

    public void setThumbUp(Integer thumbUp) {
        this.thumbUp = thumbUp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public ArticleType getType() {
        return type;
    }

    public void setType(ArticleType type) {
        this.type = type;
    }

    public List<ImageLibrary> getImglist() {
        return imglist;
    }

    public void setImglist(List<ImageLibrary> imglist) {
        this.imglist = imglist;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public Boolean getSpecial() {
        return isSpecial;
    }

    public void setSpecial(Boolean special) {
        isSpecial = special;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }
}