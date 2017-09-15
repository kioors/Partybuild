package com.kingyon.partybuild.query;

import com.kingyon.partybuild.domain.questionset.Question;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

public class QuestionsFindCountQuery implements Specification<Question> {

    private int type;
    private boolean del;

    public QuestionsFindCountQuery() {
    }

    public QuestionsFindCountQuery(int type, boolean del) {
        this.type = type;
        this.del = del;
    }

    @Override
    public Predicate toPredicate(Root<Question> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> list = new LinkedList<>();
        System.out.println("11111fawef111");
        //list.add(criteriaBuilder.equal(root.get("deleted").as(Boolean.class), del));
        //list.add(criteriaBuilder.equal(root.get("paperType").as(PaperType.class), PaperType.KNOWLEDGEBREAK));
        return null;
    }
}
