package com.kingyon.partybuild.repositories;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.partybuild.domain.questionset.PaperType;
import com.kingyon.partybuild.domain.questionset.Question;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionsRepository extends CacheRepository<Question, Long> {

    @Query("select count(id) from Question where deleted = false and paperType = ?1")
    int findCount(PaperType type);

    @Query(value = "select qs from Question qs where qs.deleted = false and qs.paperType = ?1")
    List<Question> findList(PaperType type, Pageable pageable);
}
