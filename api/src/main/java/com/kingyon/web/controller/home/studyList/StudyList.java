package com.kingyon.web.controller.home.studyList;

import com.kingyon.partybuild.service.home.StudyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Machenike on 2017/9/15.
 */
@Api(description = "获取学习讲话列表")
@Controller
@RequestMapping(value = "rest/homepage/getStudyList")
public class StudyList {

    @Autowired
    private StudyService studyService;


}
