package com.kingyon.partybuild.service.questions;

import com.kingyon.common.services.IBaseService;
import com.kingyon.partybuild.domain.questionset.Question;
import com.kingyon.partybuild.dto.api.ApiKnowledgeQuestionsResponse;

import java.util.List;

public interface IQuestionsService extends IBaseService<Question, Long> {
    /**
     * 获取知识闯关的题库数据列表
     *
     * @param uid
     * @return
     */
    List<ApiKnowledgeQuestionsResponse> getKnowledgeQuestions(long uid);
}
