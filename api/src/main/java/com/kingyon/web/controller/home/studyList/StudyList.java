package com.kingyon.web.controller.home.studyList;

import com.kingyon.api.response.RestResponse;
import com.kingyon.partybuild.service.home.StudyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Machenike on 2017/9/15.
 */
@Api(description = "获取学习讲话列表")
@Controller
@RequestMapping(value = "rest/homepage")
public class StudyList {

    @Autowired
    private StudyService studyService;

    @ApiOperation(value = "App获取学习讲话列表")
    @ResponseBody
    @RequestMapping(value = "/getStudyList")
    public RestResponse<Map<String, Object>> getStudyList(@RequestParam @ApiParam int page, @RequestParam @ApiParam int size) {


        return null;
    }

}
