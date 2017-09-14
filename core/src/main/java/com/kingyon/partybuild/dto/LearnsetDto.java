package com.kingyon.partybuild.dto;

import java.util.Date;

/**
 * Created by Machenike on 2017/9/14.
 */
public class LearnsetDto {
    /**
     * 收藏量
     */
    private Integer collection;

    /**
     * 时间
     */
    private Date date;
    /**
     * 图片链接
     */
    private String image;
    /**
     * 账号id
     */
    private Integer objectId;
    /**
     * 浏览量
     */
    private Integer pageView;
    /**
     * 点赞量
     */
    private Integer thumbUp;
    /**
     * 标题
     */
    private String title;
    /**
     * 类型 0:文章，1：内党教育，2：党课视频
     */
    private Integer type;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCollection() {
        return collection;
    }

    public String getImage() {
        return image;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public Integer getPageView() {
        return pageView;
    }

    public Integer getThumbUp() {
        return thumbUp;
    }

    public String getTitle() {
        return title;
    }

    public Integer getType() {
        return type;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    public void setThumbUp(Integer thumbUp) {
        this.thumbUp = thumbUp;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
