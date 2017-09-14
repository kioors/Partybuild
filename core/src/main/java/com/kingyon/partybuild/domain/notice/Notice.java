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
     * 公告标题
     */
    public String title;

    /**
     * 公告内容
     */
    public String detail;

    /**
     * 发布时间
     */
    public Date date;

    /**
     * 公告状态
     */
    public Integer state;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}