package com.kingyon.partybuild.repositories;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.partybuild.domain.questionset.QuestionsSets;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionsSetRepository extends CacheRepository<QuestionsSets, Long> {

    @Query("select qs from QuestionsSets qs where qs.deleted = false and qs.createAccountId = ?1 order by qs.id desc")
    List<QuestionsSets> findListByAccountId(long uid);

}
