package com.kingyon.web.controller;

import com.kingyon.api.response.ResponseStatus;
import com.kingyon.api.response.RestResponse;
import com.kingyon.partybuild.domain.DemoBean;
import com.kingyon.partybuild.service.IDemoService;
import com.kingyon.web.response.DemoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import java.util.List;
import java.util.stream.Collectors;

@Api(description = "范例接口")
@RestController
@RequestMapping(value = "/rest/demo")
public class DemoController extends AbstractRestController {

    @Autowired
    private IDemoService demoService;

    @ApiOperation(value = "测试根据name查找DemoBean")
    @RequestMapping(value = "/findDemoBeanByName", method = RequestMethod.GET)
    public RestResponse<List<DemoResponse>> findDemoBeanByName(@RequestParam @ApiParam(value = "名称") String name) {
        List<DemoBean> demoBeanList=demoService.findDemoBeanByName(name);
        List<DemoResponse> demoResponseList = demoBeanList.stream().map(source -> new DemoResponse(source)).collect(Collectors.toList());
        return new RestResponse<List<DemoResponse>>(ResponseStatus.OK, demoResponseList, "查询成功");
    }


}


