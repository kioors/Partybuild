package com.kingyon.partybuild.domain.testcount;

import com.kingyon.common.domain.AuditedDomain;
import com.kingyon.partybuild.domain.testset.Vote;
import com.kingyon.partybuild.domain.user.User;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 选举统计
 */
@Entity
@Table(name = "S_VOTE_COUNT")
public class VoteCount extends AuditedDomain {

    /**
     * Default constructor
     */
    public VoteCount() {
    }

    /**
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Vote vote;

    /**
     * 被投票人
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private User answer;

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    public User getAnswer() {
        return answer;
    }

    public void setAnswer(User answer) {
        this.answer = answer;
    }
}