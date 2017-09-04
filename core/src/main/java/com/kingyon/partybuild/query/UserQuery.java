package com.kingyon.partybuild.query;

import com.kingyon.common.domain.authorization.Role;
import com.kingyon.partybuild.domain.user.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 描述
 * <p/>
 *
 * @author <a href="sky@kingyon.com">Gang Zheng</a>
 * 2017/8/24
 * @since 0.1.0
 */
public class UserQuery implements Specification<User> {
    //用户
    private User user;

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> list = new LinkedList<>();
        if (user.getMobile() != null) {
            list.add(criteriaBuilder.equal(root.get("mobile").as(String.class), user.getMobile()));
        }
        if (user.getRoles() != null) {
            Set<Role> roles = user.getRoles();

            list.add(criteriaBuilder.equal(root.get("roles").as(String.class), user.getRoles()));
        }
        Predicate[] p = new Predicate[list.size()];
        return criteriaBuilder.and(list.toArray(p));
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
