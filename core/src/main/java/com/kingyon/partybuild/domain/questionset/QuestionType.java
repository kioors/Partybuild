package com.kingyon.partybuild.domain.questionset;

/**
 * 1单选，2多选
 *
 * @author toby
 * @create 2017-09-13 上午10:26
 **/
public enum QuestionType {
    RADIO(1, "单选"),
    CHECK(2, "多选");

    private String name;
    private Integer type;

    QuestionType(Integer type, String name) {
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

    public static QuestionType getQuestionType(int type) {
        for (QuestionType questionType : QuestionType.values()) {
            if (type == questionType.getType()) {
                return questionType;
            }
        }
        return null;
    }
}
