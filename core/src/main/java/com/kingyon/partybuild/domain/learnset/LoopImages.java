package com.kingyon.partybuild.domain.learnset;


import com.kingyon.common.domain.AuditedDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 首页轮播图
 */
@Entity
@Table(name = "S_LOOP_IMAGES")
public class LoopImages extends AuditedDomain {

    /**
     * Default constructor
     */
    public LoopImages() {
    }

    /**
     *
     */
    @ManyToOne
    private ImageLibrary loopImage;

    /**
     * 1-文章，2-文档，3-闯关，4-考试，5-专题
     */
    @Column(name = "source_type")
    private ImageUrlType sourceType;

    /**
     * 文章，文档或者专题对应具体的id
     */
    @Column(name = "source_id")
    private Long sourceId;

    public ImageLibrary getLoopImage() {
        return loopImage;
    }

    public void setLoopImage(ImageLibrary loopImage) {
        this.loopImage = loopImage;
    }

    public ImageUrlType getSourceType() {
        return sourceType;
    }

    public void setSourceType(ImageUrlType sourceType) {
        this.sourceType = sourceType;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }
}