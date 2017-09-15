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
     * 试卷标题
     */
    private String title;

    /**
     * 1民主测评，2理论考试，3问卷调查，4知识闯关
     */
    private PaperType type;

    /**
     * 简介
     */
    private String content;

    /**
     * 满分
     */
    @Column(name = "total_point")
    private Double totalPoint;

    /**
     * 题目列表
     */
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "K_SET_QUESTIONS",
            joinColumns = {@JoinColumn(name = "SET_ID", referencedColumnName = "set_id")},
            inverseJoinColumns = {@JoinColumn(name = "QUESTION_ID", referencedColumnName = "question_id")
            })
    private List<Question> quelist;

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