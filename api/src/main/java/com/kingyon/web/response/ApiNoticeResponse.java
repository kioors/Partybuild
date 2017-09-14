package com.kingyon.web.response;

public class ApiNoticeResponse {

    private long date; // 创建时间
    private String details; // 公告详情
    private String title; // 公告标题

    public ApiNoticeResponse() {
    }

    public ApiNoticeResponse(long date, String details, String title) {
        this.date = date;
        this.details = details;
        this.title = title;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
