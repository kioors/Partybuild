package com.kingyon.partybuild.repositories;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.partybuild.domain.questionset.Question;

public interface QuestionsRepository extends CacheRepository<Question, Long> {
}
