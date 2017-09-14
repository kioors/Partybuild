package com.kingyon.partybuild.domain.learnset;

import com.kingyon.common.domain.AuditedDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 党课视频
 */
@Entity
@Table(name = "S_VIDEO")
public class Video extends AuditedDomain {

    /**
     * Default constructor
     */
    public Video() {
    }

    /**
     *
     */
    private String title;

    /**
     * 收藏量
     */
    private Integer collection = 0;

    /**
     * 浏览量
     */
    @Column(name = "page_view")
    private Integer pageView = 0;

    /**
     * 点赞量
     */
    @Column(name = "thumb_up")
    private Integer thumbUp = 0;

    /**
     * 播放量
     */
    @Column(name = "play_number")
    private Integer playNumber = 0;

    /**
     * 简介
     */
    @Column(name = "brief_content")
    private String briefContent;

    /**
     * 是否为专题：0不是，1是
     */
    @Column(name = "is_special")
    private Boolean isSpecial;

    /**
     *
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 封面图
     */
    @Column(name = "head_image")
    private String headImage;

    /**
     *
     */
    private String url;

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

    public Integer getPlayNumber() {
        return playNumber;
    }

    public void setPlayNumber(Integer playNumber) {
        this.playNumber = playNumber;
    }

    public String getBriefContent() {
        return briefContent;
    }

    public void setBriefContent(String briefContent) {
        this.briefContent = briefContent;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}