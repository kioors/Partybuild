package com.kingyon.web.controller.slideshow;

import com.kingyon.api.response.ResponseStatus;
import com.kingyon.api.response.RestResponse;
import com.kingyon.partybuild.dto.api.ApiSlideshowDto;
import com.kingyon.partybuild.service.slideshow.ISlideshowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(description = "幻灯片接口")
@Controller
@RequestMapping(value = "rest")
public class SlideshowController {

    @Autowired
    private ISlideshowService slideshowService;

    @ApiOperation(value = "API获取幻灯片列表")
    @ResponseBody
    @RequestMapping(value = "/homepage/getSlideshow")
    public RestResponse<List<ApiSlideshowDto>> getSlideshowList() {
        return new RestResponse<List<ApiSlideshowDto>>(ResponseStatus.OK, slideshowService.getSlideshow(), "成功");
    }

}
