package com.kingyon.partybuild.domain.testset;

import com.kingyon.common.domain.AuditedDomain;
import com.kingyon.partybuild.domain.questionset.QuestionsSets;
import com.kingyon.partybuild.domain.user.User;

import javax.persistence.*;
import java.util.Date;

/**
 * 民主测评
 */
@Entity
@Table(name = "S_EVALUATION")
public class Evaluation extends AuditedDomain {

    /**
     * Default constructor
     */
    private Evaluation() {
    }

    /**
     * 测评对象
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private User forAccount;

    /**
     *
     */
    private String title;

    /**
     *
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     *
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 试卷
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionsSets testPaper;

    public User getForAccount() {
        return forAccount;
    }

    public void setForAccount(User forAccount) {
        this.forAccount = forAccount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public QuestionsSets getTestPaper() {
        return testPaper;
    }

    public void setTestPaper(QuestionsSets testPaper) {
        this.testPaper = testPaper;
    }
}