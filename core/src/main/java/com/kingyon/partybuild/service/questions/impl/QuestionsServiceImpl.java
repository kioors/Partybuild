package com.kingyon.partybuild.service.questions.impl;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.common.services.impl.BaseService;
import com.kingyon.partybuild.domain.questionset.Question;
import com.kingyon.partybuild.dto.api.ApiKnowledgeQuestionsResponse;
import com.kingyon.partybuild.repositories.ConnetQueOptRepository;
import com.kingyon.partybuild.repositories.QuestionsRepository;
import com.kingyon.partybuild.repositories.QuestionsSetRepository;
import com.kingyon.partybuild.service.questions.IQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "questionsService")
@Transactional(readOnly = true)
public class QuestionsServiceImpl extends BaseService<Question, Long> implements IQuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;
    @Autowired
    private QuestionsSetRepository questionsSetRepository;
    @Autowired
    private ConnetQueOptRepository connetQueOptRepository;

    @Override
    protected CacheRepository<Question, Long> getRepository() {
        return questionsRepository;
    }

    @Override
    @Transactional
    public List<ApiKnowledgeQuestionsResponse> getKnowledgeQuestions(long uid) {
//        List<QuestionsSets> questionsSets = questionsSetRepository.findListByAccountId(uid);
//        // 如果查询出来的结果集不为NULL,则将结果集中所有数据的删除状态改为TRUE,因为一个用户只能有一条正在闯关的数据
//        if (CollectionUtils.isNotEmpty(questionsSets)) {
//            for (QuestionsSets qs : questionsSets) {
//                if (qs.getDeleted()) continue;
//                qs.setDeleted(true);
//                 questionsSetRepository.save(qs);
//            }
//        }
//        QuestionsSets qs = new QuestionsSets();
//        qs.setTitle("测试标题!" + UUID.randomUUID().toString());
//        qs.setContent("测试介绍信息" + UUID.randomUUID().toString());
//        qs.setType(PaperType.KNOWLEDGEBREAK);
//        qs.setTotalPoint(100D); // 默认满分为100分
//        qs.setCreateAccountId(uid);
//        qs.setCreatedDate(new Date());
//        qs.setUpdateAccountId(uid);
//        qs.setUpdatedDate(new Date());
//        questionsSetRepository.save(qs);

        //QuestionsFindCountQuery questionsFindCountQuery = new QuestionsFindCountQuery(PaperType.KNOWLEDGEBREAK.getType(), false);
        //Page<Question> questionPage = findAllByQuery(questionsFindCountQuery, 0, 10, new Sort(Sort.Direction.ASC, "id"));
        System.out.println("((((((((((((((((");
        long count = questionsRepository.count();
        System.out.println("((((((((((((((((");
        questionsRepository.findAll();
        // List<Question> questionPage2 = questionsRepository.findAll();
        //long questionCount = questionPage.getTotalElements();

//        Pageable pageable = new PageRequest(0, 200, Sort.Direction.DESC, "id");
//        List<Question> questions = questionsRepository.findList(PaperType.KNOWLEDGEBREAK, pageable);
//        if (CollectionUtils.isNotEmpty(questions)) {
//            for (Question qsi : questions) {
//            }
//        }

        System.out.println("====================FAWF=============");
        //System.out.println(questionPage.getContent());
        //System.out.println(questionCount);
        System.out.println("=================================");

        return null;
    }

}
