package com.kingyon.web.controller.collect;

import com.kingyon.api.response.RestResponse;
import com.kingyon.partybuild.dto.LearnsetDto;
import com.kingyon.web.response.CollectResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 描述
 * <p/>
 *
 * @author <a href="Abel@kingyon.com">Abel</a>
 * 2017/9/14
 * @since 0.1.0
 */
@Api(description = "App收藏接口")
@RestController
@RequestMapping(value = "/rest/user")
public class CollectController {
    @ApiOperation(value = "获得收藏列表")
    @ResponseBody
    @RequestMapping(value = "/getCollectList" ,method = RequestMethod.GET)
    public RestResponse<List<CollectResponse>> getCollectList(@RequestParam @ApiParam(value = "页码") int page, @RequestParam @ApiParam(value = "每页数量") int size){

        return null;
    }
}
