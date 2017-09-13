package com.kingyon.partybuild.domain.learnset;

/**
 * 1通知公告，2党团计划，3党务公开
 *
 * @author toby
 * @create 2017-09-13 上午9:37
 **/
public enum ArticleType {
    NOTICE(1, "通知公告"),
    PLAN(2, "党团计划"),
    AFFAIRS(3, "党务公开");

    private String name;
    private Integer type;

    ArticleType(Integer type, String name) {
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

    public static ArticleType getArticleType(int type) {
        for (ArticleType articleType : ArticleType.values()) {
            if (type == articleType.getType()) {
                return articleType;
            }
        }
        return null;
    }
}
