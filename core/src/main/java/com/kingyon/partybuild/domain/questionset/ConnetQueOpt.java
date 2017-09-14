package com.kingyon.partybuild.domain.questionset;

import com.kingyon.common.domain.AuditedDomain;

import javax.persistence.*;

/**
 * 题目选项链接
 */
@Entity
@Table(name = "S_CONNET_QUE_OPT")
public class ConnetQueOpt extends AuditedDomain {

    /**
     * Default constructor
     */
    public ConnetQueOpt() {
    }

    /**
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    /**
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Option option;

    /**
     * 选项排序编号
     */
    @Column(name = "option_num")
    private Integer optionNum;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public Integer getOptionNum() {
        return optionNum;
    }

    public void setOptionNum(Integer optionNum) {
        this.optionNum = optionNum;
    }
}