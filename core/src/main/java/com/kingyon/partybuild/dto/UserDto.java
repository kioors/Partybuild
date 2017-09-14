package com.kingyon.partybuild.dto;

import java.util.Date;

/**
 * Created by Machenike on 2017/9/14.
 */
public class UserDto {
   private Integer collection;	//收藏量	number	@mock=$order(23434,23434,23434)
   private Date date;	//时间	number	@mock=$order(1504249086000,1504249086000,1504249086000)
   private String image;	//图片链接	string	@mock=$order('http://img2.imgtn.bdimg.com/it/u=266577561,1787924291&fm=200&gp=0.jpg','http://img2.imgtn.bdimg.com/it/u=266577561,1787924291&fm=200&gp=0.jpg','http://img2.imgtn.bdimg.com/it/u=266577561,1787924291&fm=200&gp=0.jpg')
   private Integer objectId;	//number	@mock=$order(23434,23434,23434)
   private Integer pageView;	//浏览量	number	@mock=$order(23434,23434,23434)
   private Integer thumbUp;	//点赞量	number	@mock=$order(23434,23434,23434)
   private String title;	//标题	string	@mock=$order('我的收藏标题我的收藏标题我的收藏标题我的收藏标题我的收藏标题我的收藏标题','我的收藏标题我的收藏标题我的收藏标题我的收藏标题我的收藏标题我的收藏标题','我的收藏标题我的收藏标题我的收藏标题我的收藏标题我的收藏标题我的收藏标题')
   private Integer type; //0:文章，1：内党教育，2：党课视频


    public Integer getCollection() {
        return collection;
    }

    public Date getDate() {
        return date;
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

    public void setDate(Date date) {
        this.date = date;
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
