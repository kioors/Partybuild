package com.kingyon.web.controller.personal;

import com.kingyon.api.response.ResponseStatus;
import com.kingyon.api.response.RestResponse;
import com.kingyon.partybuild.domain.user.User;
import com.kingyon.partybuild.service.personal.PersonalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述
 * <p/>
 *
 * @author <a href="Able@kingyon.com">Abel</a>
 * 2017/9/15
 * @since 0.1.0
 */
@Api(description = "获取个人资料接口")
@RestController
@RequestMapping("rest/user")
public class PersonalController {
    @Autowired
    private PersonalService personalService;
    @RequestMapping(value = "getPersonalProfile",method = RequestMethod.GET)
    public RestResponse<User> getPersonalProfile(@RequestParam  @ApiParam(value = "用户id") Long id){
            id=1L;
            if(id==null){
                return new RestResponse<User>(ResponseStatus.NOT_LOGIN,null,"登录异常");
            }

            return new RestResponse<User>();
    }

}
