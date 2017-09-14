package com.kingyon.partybuild.domain.testcount;

import com.kingyon.common.domain.AuditedDomain;
import com.kingyon.partybuild.domain.questionset.Question;
import com.kingyon.partybuild.domain.questionset.QuestionType;

import javax.persistence.*;

/**
 * 答题记录
 */
@Entity
@Table(name = "S_ANSWER_QUE_HISTORY")
public class AnswerQueHistory extends AuditedDomain {

    /**
     * Default constructor
     */
    public AnswerQueHistory() {
    }

    /**
     *
     */
    private String answer;

    /**
     * 1单选，2多选
     */
    @Column(name = "answer_type")
    private QuestionType answerType;

    /**
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    /**
     * 0错误，1正确
     */
    @Column(name = "is_right")
    private Boolean isRight;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getAnswerType() {
        return answerType;
    }

    public void setAnswerType(QuestionType answerType) {
        this.answerType = answerType;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Boolean getRight() {
        return isRight;
    }

    public void setRight(Boolean right) {
        isRight = right;
    }
}