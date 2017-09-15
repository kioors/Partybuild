package com.kingyon.partybuild.query;

import com.kingyon.partybuild.domain.learnset.OperationType;
import com.kingyon.partybuild.domain.learnset.UserOperationCount;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Machenike on 2017/9/15.
 */
public class UserOperationCountQuery implements Specification<UserOperationCount> {


    private Long userId;
    private OperationType operationType;
    private boolean del;

    public UserOperationCountQuery(Long userId, OperationType operationType, boolean del) {
        this.userId = userId;
        this.operationType = operationType;
        this.del = del;
    }

    @Override
    public Predicate toPredicate(Root<UserOperationCount> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> list = new LinkedList<>();
        list.add(criteriaBuilder.equal(root.get("deleted").as(Boolean.class), del));
        list.add(criteriaBuilder.equal(root.get("createAccountId").as(Long.class), userId));
        list.add(criteriaBuilder.equal(root.get("numType").as(OperationType.class), operationType));

        return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
    }
}
