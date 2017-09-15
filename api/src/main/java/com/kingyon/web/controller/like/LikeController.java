package com.kingyon.web.controller.like;

import com.kingyon.api.response.ResponseStatus;
import com.kingyon.api.response.RestResponse;
import com.kingyon.partybuild.domain.learnset.OperationType;
import com.kingyon.partybuild.domain.learnset.UserOperationCount;
import com.kingyon.partybuild.dto.LearnsetDto;
import com.kingyon.partybuild.query.UserOperationCountQuery;
import com.kingyon.partybuild.service.likeservice.Likeservice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Machenike on 2017/9/14.
 */
@Controller
@Api(description = "点赞API接口")
@RequestMapping(value = " rest/user")
public class LikeController {

    @Autowired
    private Likeservice likeservice;

    @RequestMapping(value = "/getThumbUpList", method = RequestMethod.GET)
    @ApiOperation(value = "点赞接口")
    public RestResponse<List<LearnsetDto>> getThumbUpList(@RequestParam @ApiParam(value = "页码") int page, @RequestParam @ApiParam(value = "每页数量") int size) {
        Long userId = 1L;

        if (userId == null) {
            return new RestResponse<>(ResponseStatus.NOT_LOGIN, null, "登录状态异常");
        }

        UserOperationCountQuery query = new UserOperationCountQuery(userId, OperationType.THUMBUP, false);
        Page<UserOperationCount> userOperationCounts = likeservice.findAllByQuery(query, page, size, new Sort(Sort.Direction.DESC));

        page = page > 0 ? page - 1 : page;

        return new RestResponse<>(ResponseStatus.OK, likeservice.getUserOperationCount(userId, page, size, OperationType.THUMBUP.getType()), "查询成功！");
    }
}
