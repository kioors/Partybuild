package com.kingyon.web.controller;

import com.kingyon.common.controller.AbstractController;
import com.kingyon.common.model.AccountModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 * <p/>
 *
 * @author <a href="sky@kingyon.com">Gang Zheng</a>
 * 2017/8/18
 * @since 0.1.0
 */
@Controller
public class IndexController extends AbstractController {

    @Override
    protected AccountModel getCurrentUser() {
        return null;
    }

    @RequestMapping(value = "index")
    public String toIndex() {
        return "layouts/service_layout";
    }

    @RequestMapping(value = "service")
    public String toService() {
        return "layouts/service_layout";
    }

    @RequestMapping(value = "garage")
    public String toGarage() {
        return "layouts/garage_layout";
    }
}
