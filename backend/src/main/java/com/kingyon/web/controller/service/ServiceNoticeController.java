package com.kingyon.web.controller.service;

import com.kingyon.api.response.ResponseStatus;
import com.kingyon.api.response.RestResponse;
import com.kingyon.partybuild.common.NullParamException;
import com.kingyon.partybuild.service.notice.INoticeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "/service")
public class ServiceNoticeController {

    @Autowired
    private INoticeService noticeService;

    @RequestMapping("/notice")
    public String toNoticeManage() {
        return "service/notice";
    }

    @ApiOperation(value = "添加公告")
    @ResponseBody
    @RequestMapping(value = "addNotice")
    public RestResponse addNotice(@RequestParam @ApiParam(value = "标题") String title, @RequestParam @ApiParam(value = "内容") String detail) {
        try {
            noticeService.addNotice(title, detail); // 添加公告
        } catch (NullParamException e) {
            return new RestResponse<>(ResponseStatus.INTERNAL_SERVER_ERROR, null, "标题和内容不能为空!");
        }
        return new RestResponse<>(ResponseStatus.OK, null, "添加成功!");
    }

    @ApiOperation(value = "删除公告")
    @ResponseBody
    @RequestMapping(value = "deleteNotice")
    public RestResponse<Object> deleteNotice(@RequestParam @ApiParam(value = "公告ID") long noticeId) {
        if (noticeId < 1) {
            return new RestResponse<Object>(ResponseStatus.INTERNAL_SERVER_ERROR, null, "ID号不能为空!");
        }
        try {
            noticeService.deleteNotice(noticeId);
        } catch (NullPointerException e) {
            return new RestResponse<Object>(ResponseStatus.INTERNAL_SERVER_ERROR, null, "删除失败，数据不存在!");
        }
        return new RestResponse<Object>(ResponseStatus.OK, null, "删除成功!");
    }

    @ApiOperation(value = "修改公告")
    @ResponseBody
    @RequestMapping(value = "modifyNotice")
    public RestResponse<Long> modifyNotice(@RequestParam @ApiParam(value = "公告ID") long noticeId, @RequestParam @ApiParam(value = "标题") String title, @RequestParam @ApiParam(value = "内容") String detail) {
        try {
            noticeService.modifyNotice(noticeId, title, detail);
        } catch (NullParamException e) {
            return new RestResponse<>(ResponseStatus.INTERNAL_SERVER_ERROR, null, "标题和内容不能为空!");
        } catch (NullPointerException e) {
            return new RestResponse<>(ResponseStatus.INTERNAL_SERVER_ERROR, null, "数据不存在!");
        }
        return new RestResponse<Long>(ResponseStatus.OK, null, "修改成功");
    }

    @ApiOperation(value = "根据ID获取公告")
    @ResponseBody
    @RequestMapping(value = "getNotice")
    public RestResponse<Map<String, Object>> getNotice(@RequestParam @ApiParam(value = "公告ID") long noticeId) {
        Map<String, Object> result = null;
        try {
            result = noticeService.getNotice(noticeId);
        } catch (NullPointerException e) {
            return new RestResponse<Map<String, Object>>(ResponseStatus.INTERNAL_SERVER_ERROR, null, "公告不存在!");
        }
        return new RestResponse<Map<String, Object>>(ResponseStatus.OK, result, "");
    }

}

