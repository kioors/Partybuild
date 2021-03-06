package com.kingyon.web.controller.notice;

import com.kingyon.api.response.ResponseStatus;
import com.kingyon.api.response.RestResponse;
import com.kingyon.common.support.data.Pager;
import com.kingyon.partybuild.domain.notice.Notice;
import com.kingyon.partybuild.domain.notice.NoticeState;
import com.kingyon.partybuild.query.NoticeQuery;
import com.kingyon.partybuild.service.notice.INoticeService;
import com.kingyon.web.response.ApiNoticeResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Api(description = "公告API接口")
@Controller
@RequestMapping(value = "rest/")
public class ApiNoticeController {

    @Autowired
    private INoticeService noticeService;

    @ApiOperation(value = "APP获取公告列表")
    @ResponseBody
    @RequestMapping(value = "/getAdvertisementMessage")
    public RestResponse<Map<String, Object>> getAdvertisementMessage(@RequestParam @ApiParam(value = "页码") int page, @RequestParam @ApiParam(value = "每页数量") int size) {
        NoticeQuery query = new NoticeQuery(null, NoticeState.release.getState(), false); // 查询条件
        page = page > 0 ? page - 1 : page;
        Page<Notice> notices = noticeService.findAllByQuery(query, page, size, new Sort(Sort.Direction.DESC, "id"));
        Pager<ApiNoticeResponse> response = new Pager<ApiNoticeResponse>(notices, notice -> new ApiNoticeResponse(notice));
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("contents", response.getContent());
        result.put("totalPages", response.getTotalPages());
        result.put("totalElements", response.getTotalElements());
        return new RestResponse<Map<String, Object>>(ResponseStatus.OK, result, "请求成功");
    }

}
