package com.kingyon.web.controller.questions;

import com.kingyon.api.response.ResponseStatus;
import com.kingyon.api.response.RestResponse;
import com.kingyon.partybuild.dto.api.ApiKnowledgeQuestionsResponse;
import com.kingyon.partybuild.service.questions.IQuestionsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(description = "知识闯关接口")
@Controller
@RequestMapping(value = "/rest/challenge")
public class ApiQuestionsController {

    @Autowired
    private IQuestionsService questionsService;

    @ApiOperation(value = "获取知识闯关题库列表,随机获取100条数据")
    @ResponseBody
    @RequestMapping(value = "getQuestions")
    public RestResponse<List<ApiKnowledgeQuestionsResponse>> getKnowledgeQuestions() {
        long uid = 0L;
        List<ApiKnowledgeQuestionsResponse> datas = questionsService.getKnowledgeQuestions(uid);
        return new RestResponse<List<ApiKnowledgeQuestionsResponse>>(ResponseStatus.OK, datas, "成功");
    }

}
