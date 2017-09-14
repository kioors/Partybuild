package com.kingyon.partybuild.domain.questionset;

import com.kingyon.common.domain.AuditedDomain;

import javax.persistence.*;

/**
 * 题目
 */
@Entity
@Table(name = "S_QUESTION")
public class Question extends AuditedDomain {

    /**
     * Default constructor
     */
    public Question() {
    }

    /**
     *
     */
    private String question;

    /**
     *
     */
    private String answer;

    /**
     * 1单选，2多选
     */
    private QuestionType type;

    /**
     * 问题所属板块：1知识闯关，2民主测评，3理论考试，4问卷调查，
     */
    @Column(name = "paper_type")
    private PaperType paperType;

    /**
     *
     */
    private Double point;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionsSets questionsSets;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public PaperType getPaperType() {
        return paperType;
    }

    public void setPaperType(PaperType paperType) {
        this.paperType = paperType;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public QuestionsSets getQuestionsSets() {
        return questionsSets;
    }

    public void setQuestionsSets(QuestionsSets questionsSets) {
        this.questionsSets = questionsSets;
    }
}