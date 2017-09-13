package com.kingyon.partybuild.domain.testset;

import com.kingyon.common.domain.AuditedDomain;
import com.kingyon.partybuild.domain.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 投票选举
 */
@Entity
@Table(name = "S_VOTE")
public class Vote extends AuditedDomain {

    /**
     * Default constructor
     */
    public Vote() {
    }

    /**
     *
     */
    public String title;

    /**
     *
     */
    @Column(name = "start_time")
    public Date startTime;

    /**
     *
     */
    @Column(name = "end_time")
    public Date endTime;

    /**
     * 投票对象
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "K_VOTE_USER", joinColumns = {@JoinColumn(name = "vote_id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
    public List<User> votelist;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<User> getVotelist() {
        return votelist;
    }

    public void setVotelist(List<User> votelist) {
        this.votelist = votelist;
    }
}