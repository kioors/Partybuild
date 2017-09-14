package com.kingyon.partybuild.domain.message;

import com.kingyon.common.domain.AuditedDomain;
import com.kingyon.partybuild.domain.user.User;

import javax.persistence.*;

/**
 * 留言消息
 */
@Entity
@Table(name = "S_MESSAGE")
public class Message extends AuditedDomain {

    /**
     * Default constructor
     */
    public Message() {
    }

    /**
     * 如果是文本留言就是内容，如果是图片留言是图片的key
     */
    private String content;

    /**
     *
     */
    @Column(name = "image_height")
    private Double imageHeight;

    /**
     *
     */
    @Column(name = "image_width")
    private Double imageWidth;

    /**
     * 1图片消息，2文本消息
     */
    private MessageType type;

    /**
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private User toAccount;

    /**
     * 是否已读：0未读，1已读
     */
    @Column(name = "is_read")
    private Boolean isRead;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(Double imageHeight) {
        this.imageHeight = imageHeight;
    }

    public Double getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(Double imageWidth) {
        this.imageWidth = imageWidth;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public User getToAccount() {
        return toAccount;
    }

    public void setToAccount(User toAccount) {
        this.toAccount = toAccount;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }
}