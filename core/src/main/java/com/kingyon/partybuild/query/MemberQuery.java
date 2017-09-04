package com.kingyon.partybuild.query;

import com.kingyon.partybuild.domain.member.Member;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

/**
 * com.kingyon.partybuild.query
 * <p/>
 *
 * @author <a href="libing@kingyon.com">XiaoDong Yuan</a>
 * 2017/8/11 0011
 * @since 0.1.0
 */
public class MemberQuery implements Specification<Member> {

    //微信uuid
    private String openId;

    private Long id;

    private String mobile;

    @Override
    public Predicate toPredicate(Root<Member> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> list = new LinkedList<>();
        if (StringUtils.isNotBlank(openId)) {
            list.add(criteriaBuilder.equal(root.get("openId").as(String.class), openId));
        }
        Predicate[] p = new Predicate[list.size()];
        return criteriaBuilder.and(list.toArray(p));
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
