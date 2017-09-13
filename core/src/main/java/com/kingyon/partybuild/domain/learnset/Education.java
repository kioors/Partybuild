package com.kingyon.partybuild.domain.learnset;

import com.kingyon.common.domain.AuditedDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 党内教育（附件）
 */
@Entity
@Table(name = "S_EDUCATION")
public class Education extends AuditedDomain {

    /**
     * Default constructor
     */
    public Education() {
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
     * 简介
     */
    @Column(name = "brief_content")
    public String briefContent;

    /**
     *
     */
    public String url;

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
     * 文章推荐图
     */
    @Column(name = "head_image")
    public String headImage;

    /**
     * 1-txt，2-word，3-pdf
     */
    @Column(name = "document_type")
    public FileType documentType;

    /**
     * 作者
     */
    public String author;

    /**
     * 出版社
     */
    @Column(name = "press_name")
    public String pressName;

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

    public String getBriefContent() {
        return briefContent;
    }

    public void setBriefContent(String briefContent) {
        this.briefContent = briefContent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public FileType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(FileType documentType) {
        this.documentType = documentType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPressName() {
        return pressName;
    }

    public void setPressName(String pressName) {
        this.pressName = pressName;
    }
}