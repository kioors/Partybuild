package com.kingyon.partybuild.domain.learnset;

/**
 * 1通知公告，2党团计划，3党务公开
 *
 * @author toby
 * @create 2017-09-13 上午9:37
 **/
public enum VideoType {

    NOTICE(1, "通知公告"),
    PLAN(2, "党团计划"),
    AFFAIRS(3, "党务公开"),
    LEARNING(4, "学习讲话"),
    DYNAMICS(5, "党建动态"),
    EDUCATION(6, "党内教育"),
    REGULATIONS(7, "政策法规"),
    GUIDE(8, "办事指南"),
    BOUTIQUE(9, "精品党课");

    private String name;
    private Integer type;

    VideoType(Integer type, String name) {
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

    public static VideoType getArticleType(int type) {
        for (VideoType articleType : VideoType.values()) {
            if (type == articleType.getType()) {
                return articleType;
            }
        }
        return null;
    }
}
