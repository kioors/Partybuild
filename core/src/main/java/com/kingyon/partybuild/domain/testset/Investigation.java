package com.kingyon.partybuild.domain.testset;

import com.kingyon.common.domain.AuditedDomain;
import com.kingyon.partybuild.domain.questionset.QuestionsSets;

import javax.persistence.*;
import java.util.Date;

/**
 * 问卷调查
 */
@Entity
@Table(name = "S_INVESTIGATION")
public class Investigation extends AuditedDomain {

    /**
     * Default constructor
     */
    public Investigation() {
    }

    /**
     *
     */
    public String title;

    /**
     *
     */
    @Column(name = "start_time")
    public Date startTime;

    /**
     *
     */
    @Column(name = "end_time")
    public Date endTime;

    /**
     * 试卷
     */
    @ManyToOne(fetch = FetchType.LAZY)
    public QuestionsSets testPaper;

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