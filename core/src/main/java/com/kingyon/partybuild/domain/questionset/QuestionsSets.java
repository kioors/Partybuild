package com.kingyon.partybuild.domain.questionset;

import com.kingyon.common.domain.AuditedDomain;

import javax.persistence.*;
import java.util.List;

/**
 * 套题题库
 */
@Entity
@Table(name = "S_QUESTIONS_SETS")
public class QuestionsSets extends AuditedDomain {

    /**
     * Default constructor
     */
    public QuestionsSets() {
    }

    /**
     *
     */
    public String title;

    /**
     * 1民主测评，2理论考试，3问卷调查，4知识闯关
     */
    public PaperType type;

    /**
     * 简介
     */
    public String content;

    /**
     * 满分
     */
    @Column(name = "total_point")
    public Double totalPoint;

    /**
     *
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "questionsSets")
    public List<Question> quelist;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PaperType getType() {
        return type;
    }

    public void setType(PaperType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(Double totalPoint) {
        this.totalPoint = totalPoint;
    }

    public List<Question> getQuelist() {
        return quelist;
    }

    public void setQuelist(List<Question> quelist) {
        this.quelist = quelist;
    }
}