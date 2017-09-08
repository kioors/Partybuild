package com.kingyon.web.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingyon.partybuild.model.UserModel;
import com.kingyon.web.utils.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 帐号相关URL
 * <p/>
 *
 * @author <a href="libing@kingyon.com">Libing Huang</a>
 * 2017/8/7 下午4:29
 * @since 0.1.0
 */
@Controller
@RequestMapping(value = "test")
public class TestController extends AbstractController {


    @RequestMapping("/tableDemoAjax")
    @ResponseBody
    public String tableDemoAjax(@RequestParam String aoData, String status, String username) {

        JSONArray jsonarray = JSONArray.parseArray(aoData);

        String sEcho = null;
        int iDisplayStart = 0; // 起始索引
        int iDisplayLength = 0; // 每页显示的行数

        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject obj = (JSONObject) jsonarray.get(i);
            if (obj.get("name").equals("sEcho"))
                sEcho = obj.get("value").toString();

            if (obj.get("name").equals("iDisplayStart"))
                iDisplayStart = obj.getInteger("value");

            if (obj.get("name").equals("iDisplayLength"))
                iDisplayLength = obj.getInteger("value");
        }

//        // 生成20条测试数据
//        List<String[]> lst = new ArrayList<String[]>();
//        String[] dd = { "username", "Email" , "Points", "Joined"};
//        lst.add(dd);
//        for (int i = 0; i < 20; i++) {
//            String[] d = { "co1_data" + i, "col2_data" + i , "col3_data" + i, "col4_data" + i};
//            lst.add(d);
//        }

        List<UserModel> lst = new ArrayList<UserModel>();
        int totalNum = 36;
        int endNum = iDisplayStart + iDisplayLength;
        if (endNum > totalNum) {
            endNum = totalNum;
        }
        for (int i = iDisplayStart; i < endNum; i++) {
            UserModel user = new UserModel();
            user.setId(i + 10l);
            user.setName("mame" + i);
            user.setMobile("mobile" + i);
            user.setPassword("password" + i);
            lst.add(user);
        }
        JSONObject getObj = new JSONObject();
        getObj.put("sEcho", sEcho);
        getObj.put("iTotalRecords", totalNum);//实际的行数
        getObj.put("iTotalDisplayRecords", totalNum);//显示的行数,这个要和上面写的一样

        getObj.put("aaData", lst);//要以JSON格式返回
        return getObj.toString();
    }


}
