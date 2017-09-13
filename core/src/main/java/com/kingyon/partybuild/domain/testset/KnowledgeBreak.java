package com.kingyon.partybuild.domain.testset;


import com.kingyon.common.domain.AuditedDomain;
import com.kingyon.partybuild.domain.questionset.QuestionsSets;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 知识闯关
 */
@Entity
@Table(name = "S_KNOWLEDGE_BREAK")
public class KnowledgeBreak extends AuditedDomain {

    /**
     * Default constructor
     */
    public KnowledgeBreak() {
    }

    /**
     *
     */
    public String title;

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

    public QuestionsSets getTestPaper() {
        return testPaper;
    }

    public void setTestPaper(QuestionsSets testPaper) {
        this.testPaper = testPaper;
    }
}