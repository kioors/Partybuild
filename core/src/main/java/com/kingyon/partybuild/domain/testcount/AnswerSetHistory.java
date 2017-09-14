package com.kingyon.partybuild.domain.testcount;

import com.kingyon.common.domain.AuditedDomain;
import com.kingyon.partybuild.domain.questionset.QuestionsSets;

import javax.persistence.*;

/**
 * 套题总分记录
 */
@Entity
@Table(name = "S_ANSWER_SET_HISTORY")
public class AnswerSetHistory extends AuditedDomain {

    /**
     * Default constructor
     */
    public AnswerSetHistory() {
    }

    /**
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionsSets questionsSets;

    /**
     * 得分
     */
    @Column(name = "result_point")
    private Boolean resultPoint;

    public QuestionsSets getQuestionsSets() {
        return questionsSets;
    }

    public void setQuestionsSets(QuestionsSets questionsSets) {
        this.questionsSets = questionsSets;
    }

    public Boolean getResultPoint() {
        return resultPoint;
    }

    public void setResultPoint(Boolean resultPoint) {
        this.resultPoint = resultPoint;
    }
}