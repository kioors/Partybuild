package com.kingyon.partybuild.domain.user;

/**
 * @author toby
 * @create 2017-09-12 下午5:04
 **/
public enum IdentityType {
    MEMBER(1, "普通党员"),
    SECRETARY(2, "支部书记");

    private String name;
    private Integer type;

    IdentityType(Integer type, String name) {
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

    public static IdentityType getIdentityType(int type) {
        for (IdentityType identityType : IdentityType.values()) {
            if (type == identityType.getType()) {
                return identityType;
            }
        }
        return null;
    }
}
