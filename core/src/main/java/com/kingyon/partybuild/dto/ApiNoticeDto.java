package com.kingyon.partybuild.dto;

import com.kingyon.partybuild.domain.notice.Notice;

public class ApiNoticeDto {

    private long date; // 发布时间
    private String title; // 标题
    private String details; // 公告内容

    public ApiNoticeDto() {
    }

    public ApiNoticeDto(long date, String title, String details) {
        this.date = date;
        this.title = title;
        this.details = details;
    }

    public ApiNoticeDto(Notice notice) {
        this.date = notice.getDate().getTime();
        this.title = notice.getTitle();
        this.details = notice.getDetail();
    }

    @Override
    public String toString() {
        return "ApiNoticeDto{" +
                "date=" + date +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                '}';
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
