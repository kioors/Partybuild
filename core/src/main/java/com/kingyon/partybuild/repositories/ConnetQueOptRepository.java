package com.kingyon.partybuild.repositories;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.partybuild.domain.questionset.ConnetQueOpt;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConnetQueOptRepository extends CacheRepository<ConnetQueOpt, Long> {

    @Query("select q from ConnetQueOpt q where q.deleted = false and q.question.id in (?1)")
    List<ConnetQueOpt> findByQuestionIdBuffer(String idBuffer);
}
