package com.kingyon.web.controller;

import com.kingyon.partybuild.service.IMemberService;
import com.kingyon.partybuild.service.ISecurityCodeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 帐号相关URL
 * <p/>
 *
 * @author <a href="libing@kingyon.com">Libing Huang</a>
 *         2017/8/7 下午4:29
 * @since 0.1.0
 */
@Api(description = "账号认证相关接口")
@RestController
@RequestMapping(value = "/rest/account")
public class AccountController extends AbstractRestController {

    @Autowired
    private ISecurityCodeService securityCodeService;

    @Autowired
    private IMemberService memberService;

}


