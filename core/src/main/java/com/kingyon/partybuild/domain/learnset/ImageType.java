package com.kingyon.partybuild.domain.learnset;

/**
 * @author toby
 * @create 2017-09-13 上午9:53
 **/
public enum ImageType {
    ARTICLE(1, "文章图"),
    LOOP(2, "首页轮播图");

    private String name;
    private Integer type;

    ImageType(Integer type, String name) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public static ImageType getImageType(int type) {
        for (ImageType imageType : ImageType.values()) {
            if (type == imageType.getType()) {
                return imageType;
            }
        }
        return null;
    }
}
