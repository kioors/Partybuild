package com.kingyon.partybuild.domain.learnset;

/**
 * 1收藏，2浏览，3点赞
 *
 * @author toby
 * @create 2017-09-13 上午10:04
 **/
public enum OperationType {
    COLLECTION(1, "收藏"),
    PAGEVIEW(2, "浏览"),
    THUMBUP(3, "点赞");

    private String name;
    private Integer type;

    OperationType(Integer type, String name) {
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

    public static OperationType getOperationType(int type) {
        for (OperationType operationType : OperationType.values()) {
            if (type == operationType.getType()) {
                return operationType;
            }
        }
        return null;
    }
}
