package com.kingyon.partybuild.dto.api;

/**
 * 知识闯关API数据返回
 */
public class ApiKnowledgeQuestionsResponse {

    private ApiKnowledgeAnwserOptionsResponse anwserOptions; // 问题选项
    private long objectId; // 问题ID
    private String question; // 问题内容
    private boolean radio; // 是否单选

    public ApiKnowledgeQuestionsResponse() {
    }

    public ApiKnowledgeQuestionsResponse(ApiKnowledgeAnwserOptionsResponse anwserOptions, long objectId, String question, boolean radio) {
        this.anwserOptions = anwserOptions;
        this.objectId = objectId;
        this.question = question;
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "ApiKnowledgeQuestionsResponse{" +
                "anwserOptions=" + anwserOptions +
                ", objectId=" + objectId +
                ", question='" + question + '\'' +
                ", radio=" + radio +
                '}';
    }

    public ApiKnowledgeAnwserOptionsResponse getAnwserOptions() {
        return anwserOptions;
    }

    public void setAnwserOptions(ApiKnowledgeAnwserOptionsResponse anwserOptions) {
        this.anwserOptions = anwserOptions;
    }

    public long getObjectId() {
        return objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isRadio() {
        return radio;
    }

    public void setRadio(boolean radio) {
        this.radio = radio;
    }
}
