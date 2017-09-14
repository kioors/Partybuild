package com.kingyon.partybuild.domain.attachment;

import com.kingyon.common.domain.attachment.Attachment;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 图片附件
 * <p/>
 *
 * @author <a href="libing@kingyon.com">Libing Huang</a>
 * 2017/8/7 下午7:48
 * @since 0.1.0
 */
@Entity
@Table(name = "s_picture_attachment")
public class PictureAttachment extends Attachment {

    public PictureAttachment(String path) {
        setPath(path);
    }

    public PictureAttachment() {
    }

}
