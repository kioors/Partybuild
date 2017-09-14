package com.kingyon.partybuild.domain.report;

import com.kingyon.common.domain.AuditedDomain;
import com.kingyon.partybuild.domain.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 汇报
 */
@Entity
@Table(name = "S_REPORT")
public class Report extends AuditedDomain {

    /**
     * Default constructor
     */
    public Report() {
    }

    /**
     *
     */
    @Column(name = "to_account")
    private User toAccount;

    /**
     *
     */
    private String content;

    /**
     *
     */
    private String reply;

    /**
     * 1待回复，2已回复
     */
    private String status;

    public User getToAccount() {
        return toAccount;
    }

    public void setToAccount(User toAccount) {
        this.toAccount = toAccount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}