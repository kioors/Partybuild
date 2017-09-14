package com.kingyon.web.controller.article;

import com.kingyon.api.response.ResponseStatus;
import com.kingyon.api.response.RestResponse;
import com.kingyon.partybuild.common.NullParamException;
import com.kingyon.partybuild.service.article.IArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(description = "文章API接口")
@Controller
@RequestMapping(value = "/rest")
public class ApiArticleController {

    @Autowired
    private IArticleService articleService;

    @ApiOperation(value = "支部发布文章")
    @ResponseBody
    @RequestMapping(value = "/party/publish")
    public RestResponse<Object> partyPublishArticle(@RequestParam @ApiParam(value = "文章内容") String content, @RequestParam @ApiParam(value = "图片KEY") String imageKeys, @RequestParam @ApiParam(value = "文章标题") String title, @RequestParam @ApiParam(value = "文章分类") int type) {
        long uid = 1; // 因为目前无法通过token获得用户的ID号,所以这里创建一个固定的ID号做测试用
        try {
            articleService.partyPublishArticle(content, imageKeys, title, type, uid);
        } catch (NullParamException e) {
            e.printStackTrace();
            return new RestResponse<Object>(ResponseStatus.INTERNAL_SERVER_ERROR, null, "发布失败");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResponse<Object>(ResponseStatus.INTERNAL_SERVER_ERROR, null, "发布失败");
        }
        return new RestResponse<Object>(ResponseStatus.OK, null, "成功");
    }

}
