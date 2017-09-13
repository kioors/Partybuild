package com.kingyon.partybuild.domain.learnset;

/**
 * 1-文章，2-文档，3-闯关，4-考试，5-专题
 *
 * @author toby
 * @create 2017-09-13 上午9:55
 **/
public enum ImageUrlType {
    ARTICLE(1, "文章"),
    FILE(2, "文档"),
    KNOWLEDGEBREAK(3, "闯关"),
    EXAMINATION(4, "考试"),
    SPECIAL(5, "专题");

    private String name;
    private Integer type;

    ImageUrlType(Integer type, String name) {
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

    public static ImageUrlType getImageUrlType(int type) {
        for (ImageUrlType imageUrlType : ImageUrlType.values()) {
            if (type == imageUrlType.getType()) {
                return imageUrlType;
            }
        }
        return null;
    }
}
