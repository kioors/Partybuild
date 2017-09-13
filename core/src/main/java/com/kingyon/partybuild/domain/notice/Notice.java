package com.kingyon.partybuild.domain.notice;

import com.kingyon.common.domain.AuditedDomain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 公告
 */
@Entity
@Table(name = "S_NOTICE")
public class Notice extends AuditedDomain {

    /**
     * Default constructor
     */
    public Notice() {
    }

    /**
     *
     */
    public String title;

    /**
     *
     */
    public String detail;

    /**
     *
     */
    public Date date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}