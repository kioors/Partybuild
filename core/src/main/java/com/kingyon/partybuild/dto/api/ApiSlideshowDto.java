package com.kingyon.partybuild.dto.api;

public class ApiSlideshowDto {

    private String image; // 图片地址
    private long objectId; // 对应的具体ID
    private int type; // 类型,如文章文档类的

    public ApiSlideshowDto() {
    }

    public ApiSlideshowDto(String image, long objectId, int type) {
        this.image = image;
        this.objectId = objectId;
        this.type = type;
    }

    @Override
    public String toString() {
        return "ApiSlideshowDto{" +
                "image='" + image + '\'' +
                ", objectId=" + objectId +
                ", type=" + type +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getObjectId() {
        return objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
