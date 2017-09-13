package com.kingyon.partybuild.domain.learnset;


import com.kingyon.common.domain.AuditedDomain;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loopImages", cascade = CascadeType.ALL)
    public List<ImageLibrary> imagelist;

    /**
     * 1-文章，2-文档，3-闯关，4-考试，5-专题
     */
    @Column(name = "source_type")
    public ImageUrlType sourceType;

    /**
     * 文章，文档或者专题对应具体的id
     */
    @Column(name = "source_id")
    public Long sourceId;

    public List<ImageLibrary> getImagelist() {
        return imagelist;
    }

    public void setImagelist(List<ImageLibrary> imagelist) {
        this.imagelist = imagelist;
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