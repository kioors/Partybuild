package com.kingyon.partybuild.domain.learnset;

/**
 * 1文章，2附件，3视频
 *
 * @author toby
 * @create 2017-09-13 上午10:08
 **/
public enum SourceType {
    ARTICLE(1, "文章"),
    ENCLOSURE(2, "附件"),
    VIDEO(3, "视频");

    private String name;
    private Integer type;

    SourceType(Integer type, String name) {
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

    public static SourceType getSourceType(int type) {
        for (SourceType sourceType : SourceType.values()) {
            if (type == sourceType.getType()) {
                return sourceType;
            }
        }
        return null;
    }
}
