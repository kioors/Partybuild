package com.kingyon.partybuild.query;

import com.kingyon.partybuild.domain.learnset.UserOperationCount;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * 描述
 * <p/>
 *
 * @author <a href="jorge@kingyon.com">Jorge</a>
 * 2017/9/14
 * @since 0.1.0
 */
public class CollectQuery implements Specification<UserOperationCount> {


    @Override
    public Predicate toPredicate(Root<UserOperationCount> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
