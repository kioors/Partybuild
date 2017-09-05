package com.kingyon.web.controller.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 运营平台首页控制器
 * <p/>
 *
 * @author <a href="sky@kingyon.com">Gang Zheng</a>
 * 2017/8/22
 * @since 0.1.0
 */
@Controller
@RequestMapping(value = "service/index")
public class ServiceIndexController {
    @RequestMapping
    public String toIndex(Model model) {
        return "service/index";
    }
}
