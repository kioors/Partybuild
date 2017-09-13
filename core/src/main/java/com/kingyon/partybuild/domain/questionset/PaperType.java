package com.kingyon.partybuild.domain.questionset;

/**
 * 1民主测评，2理论考试，3问卷调查，4知识闯关
 *
 * @author toby
 * @create 2017-09-13 上午10:26
 **/
public enum PaperType {
    EVALUATION(1, "民主测评"),
    EXAMINATION(2, "理论考试"),
    INVESTIGATION(3, "问卷调查"),
    KNOWLEDGEBREAK(4, "知识闯关");

    private String name;
    private Integer type;

    PaperType(Integer type, String name) {
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

    public static PaperType getPaperType(int type) {
        for (PaperType paperType : PaperType.values()) {
            if (type == paperType.getType()) {
                return paperType;
            }
        }
        return null;
    }
}
