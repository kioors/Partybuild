package com.kingyon.partybuild.service.questions.impl;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.common.services.impl.BaseService;
import com.kingyon.partybuild.domain.questionset.*;
import com.kingyon.partybuild.dto.api.ApiKnowledgeQuestionsResponse;
import com.kingyon.partybuild.query.QuestionsFindCountQuery;
import com.kingyon.partybuild.repositories.ConnetQueOptRepository;
import com.kingyon.partybuild.repositories.QuestionsRepository;
import com.kingyon.partybuild.repositories.QuestionsSetRepository;
import com.kingyon.partybuild.service.questions.IQuestionsService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
        List<QuestionsSets> questionsSets = questionsSetRepository.findListByAccountId(uid);
        // 如果查询出来的结果集不为NULL,则将结果集中所有数据的删除状态改为TRUE,因为一个用户只能有一条正在闯关的数据
        if (CollectionUtils.isNotEmpty(questionsSets)) {
            for (QuestionsSets qs : questionsSets) {
                if (qs.getDeleted()) continue;
                qs.setDeleted(true);
                questionsSetRepository.save(qs);
            }
        }

        // 保存试卷到库中
        QuestionsSets qs = new QuestionsSets();
        qs.setTitle("测试标题!" + UUID.randomUUID().toString());
        qs.setContent("测试介绍信息" + UUID.randomUUID().toString());
        qs.setType(PaperType.KNOWLEDGEBREAK);
        qs.setTotalPoint(100D); // 默认满分为100分
        qs.setCreateAccountId(uid);
        qs.setCreatedDate(new Date());
        qs.setUpdateAccountId(uid);
        qs.setUpdatedDate(new Date());
        questionsSetRepository.save(qs);

        /**
         * 随机获取数据的方式; 因jpa默认不支持随机从数据库查询,所以这里做了逻辑获取
         * 1. 查询数据库得到总数量, 根据总数量来计算分页,每页1000条数据
         * 2. 再根据计算的分页,随机获取1000条数据出来,通过Collections.shuffler打乱list顺序,再获取前100条数据结果;
         */
        QuestionsFindCountQuery questionsFindCountQuery = new QuestionsFindCountQuery(PaperType.KNOWLEDGEBREAK.getType(), false);
        Page<Question> questionPage = findAllByQuery(questionsFindCountQuery, 0, 10, new Sort(Sort.Direction.ASC, "id"));
        long count = questionPage.getTotalElements(); // 查询数据库得到总记录数

        long pageNumber = 0;
        if (count > 1000) {
            // 计算一共有多少页码, 每页1000条数据,如果剩余的数量超过500条,则剩余的500条数据也做为一页加入
            System.out.println(count % 1000 > 500 ? (count / 1000) + 1 : count / 1000);
            pageNumber = count % 1000 > 500 ? (count / 1000) + 1 : count / 1000;
            pageNumber = new Random().nextInt(Integer.parseInt(String.valueOf(pageNumber))) + 1;
        }

        // 根据随机生成的面码,获取1000条数据出来,
        questionPage = findAllByQuery(questionsFindCountQuery, Integer.parseInt(String.valueOf(pageNumber)), 1000, new Sort(Sort.Direction.ASC, "id"));
        List<Question> questions = questionPage.getContent();
        if (CollectionUtils.isEmpty(questions)) {
            return new ArrayList<ApiKnowledgeQuestionsResponse>();
        }

        // 将获取出来的结果顺序打乱,再获取100条出来做为随机的数据
        // Collections.shuffle(questions);
        List<Question> datas = questions.size() > 100 ? questions.subList(0, 100) : questions;

        // 这个是用来拼接in查询条件的,查询ConnetQueOpt数据表,
        // 如果不使用这种方式,会循环查询数据库100次,比较吃内存
        List<ApiKnowledgeQuestionsResponse> results = new ArrayList<ApiKnowledgeQuestionsResponse>();
        StringBuffer idBuffer = new StringBuffer();
        if (CollectionUtils.isNotEmpty(datas)) {
            List<Question> setQuestionList = new ArrayList<Question>();
            Question qus = null;
            for (Question qu : datas) {
                setQuestionList.add(qu); // 循环保存数据(试卷与题目的关联)
                // 根据题目获取选项,封装到返回类中
                idBuffer.append(qu.getId()).append(",");
            }
            qs.setQuelist(setQuestionList);
            questionsSetRepository.save(qs); // 重新修改数据
            setQuestionList = null;

            // 以下是返回数据的封装处理
            // 截取最后一个,符号
            idBuffer = new StringBuffer().append(idBuffer.toString().substring(0, idBuffer.toString().length() - 1));
            List<ConnetQueOpt> options = connetQueOptRepository.findByQuestionIdBuffer(idBuffer.toString());
            if (CollectionUtils.isNotEmpty(options)) {
                ApiKnowledgeQuestionsResponse resp = new ApiKnowledgeQuestionsResponse();
                for (ConnetQueOpt cqo : options) {
                    resp.setObjectId(cqo.getQuestion().getId()); // 题目ID
                    resp.setRadio(cqo.getQuestion().getType().getType() == QuestionType.RADIO.getType()); // 是否为单选
                    resp.setQuestion(cqo.getQuestion().getQuestion()); // 名称
                }
            }
        }
        return results;
    }

}
