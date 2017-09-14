package com.kingyon.partybuild.query;

import com.kingyon.partybuild.domain.notice.Notice;
import com.kingyon.partybuild.domain.notice.NoticeState;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

public class NoticeQuery implements Specification<Notice> {

    private String title; // 搜索的标题
    private int state; // 搜索的状态
    private boolean del; // 删除状态

    public NoticeQuery() {
    }

    public NoticeQuery(String title, int state) {
        this.title = title;
        this.state = state;
    }

    public NoticeQuery(String title, int state, boolean del) {
        this.title = title;
        this.state = state;
        this.del = del;
    }

    @Override
    public Predicate toPredicate(Root<Notice> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> list = new LinkedList<>();
        list.add(criteriaBuilder.equal(root.get("deleted").as(Boolean.class), del));
        if (StringUtils.isNotEmpty(title)) {
            list.add(criteriaBuilder.like(root.get("title").as(String.class), "%" + title + "%"));
        }
        if (state == NoticeState.notRelease.getState() || state == NoticeState.release.getState()) {
            list.add(criteriaBuilder.equal(root.get("state").as(Integer.class), state));
        }
        return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
    }
}
