package com.kingyon.partybuild.domain.learnset;

import com.kingyon.common.domain.AuditedDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 统计用户对资源的操作表
 */
@Entity
@Table(name = "S_USER_OPERATION_COUNT")
public class UserOperationCount extends AuditedDomain {

    /**
     * Default constructor
     */
    public UserOperationCount() {
    }

    /**
     * 操作的资源类型：1文章，2附件，3视频
     */
    @Column(name = "source_type")
    public SourceType sourceType;

    /**
     * 弱关联，根据type关联对应的表id
     */
    @Column(name = "source_id")
    public Long sourceId;

    /**
     * 操作类型：1收藏，2浏览，3点赞
     */
    @Column(name = "num_type")
    public OperationType numType;

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public OperationType getNumType() {
        return numType;
    }

    public void setNumType(OperationType numType) {
        this.numType = numType;
    }
}