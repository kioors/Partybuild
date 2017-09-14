package com.kingyon.partybuild.dto;

import java.util.Date;

public class NoticeDto {

    private long id; // ID号
    private Date date; // 发布时间
    private int state; // 状态值
    private String stateName; // 状态名称
    private String title; // 标题
    private String detail; // 内容,获取列表时,此属性可为NULL

    public NoticeDto() {
    }

    public NoticeDto(long id, Date date, int state, String stateName, String title, String detail) {
        this.id = id;
        this.date = date;
        this.state = state;
        this.stateName = stateName;
        this.title = title;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "NoticeDto{" +
                "id=" + id +
                ", date=" + date +
                ", state=" + state +
                ", stateName='" + stateName + '\'' +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

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
}
