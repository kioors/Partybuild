package com.kingyon.partybuild.domain.questionset;

import com.kingyon.common.domain.AuditedDomain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 试题选项
 */
@Entity
@Table(name = "S_OPTION")
public class Option extends AuditedDomain {

    /**
     * Default constructor
     */
    public Option() {
    }

    /**
     * 选项描述
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}