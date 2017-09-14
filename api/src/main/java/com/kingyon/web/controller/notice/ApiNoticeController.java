package com.kingyon.web.controller.notice;

import com.kingyon.api.response.ResponseStatus;
import com.kingyon.api.response.RestResponse;
import com.kingyon.web.response.ApiNoticeResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Api(description = "公告API接口")
@Controller
@RequestMapping(value = "rest/")
public class ApiNoticeController {

    @ApiOperation(value = "APP获取公告列表")
    @ResponseBody
    @RequestMapping(value = "/getAdvertisementMessage")
    public RestResponse<List<ApiNoticeResponse>> getAdvertisementMessage(@RequestParam @ApiParam(value = "页码") int page, @RequestParam @ApiParam(value = "每页数量") int size) {
        List<ApiNoticeResponse> dataList = new ArrayList<ApiNoticeResponse>();
        for (int i = 0; i < 100; i++) {
            dataList.add(new ApiNoticeResponse(new Date().getTime(), UUID.randomUUID().toString(), UUID.randomUUID().toString()));
        }
        return new RestResponse<>(ResponseStatus.OK, dataList, "获取成功");
    }

}
