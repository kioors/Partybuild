package com.kingyon.partybuild.domain.notice;

public enum NoticeState {

    notRelease(-1, "待发布"), release(0, "已发布");

    private int state;
    private String value;

    NoticeState() {
    }

    NoticeState(int state, String value) {
        this.state = state;
        this.value = value;
    }

    @Override
    public String toString() {
        return "NoticeState{" +
                "state=" + state +
                ", value='" + value + '\'' +
                '}';
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
