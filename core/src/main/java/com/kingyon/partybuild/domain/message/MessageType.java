package com.kingyon.partybuild.domain.message;

/**
 * @author toby
 * @create 2017-09-13 上午10:12
 **/
public enum MessageType {
    image(1, "图片消息"),
    text(2, "文本消息");

    private String name;
    private Integer type;

    MessageType(Integer type, String name) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public static MessageType getMessageType(int type) {
        for (MessageType messageType : MessageType.values()) {
            if (type == messageType.getType()) {
                return messageType;
            }
        }
        return null;
    }
}
