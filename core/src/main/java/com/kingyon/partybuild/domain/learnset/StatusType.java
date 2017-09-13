package com.kingyon.partybuild.domain.learnset;

/**
 * @author toby
 * @create 2017-09-13 上午9:25
 **/
public enum StatusType {
    CHECKING(0, "审核中"),
    PASS(1, "已通过"),
    NOTPASS(2, "未通过");

    private String name;
    private Integer type;

    StatusType(Integer type, String name) {
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

    public static StatusType getStatusType(int type) {
        for (StatusType statusType : StatusType.values()) {
            if (type == statusType.getType()) {
                return statusType;
            }
        }
        return null;
    }
}
