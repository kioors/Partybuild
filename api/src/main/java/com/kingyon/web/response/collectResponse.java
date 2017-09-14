package com.kingyon.web.response;

import java.util.List;

/**
 * 描述 收藏返回类
 * <p/>
 *
 * @author <a href="Abel@kingyon.com">Abel/a>
 * 2017/9/14
 * @since 0.1.0
 */
public class collectResponse<T> {

    private  String type;

    private List<T> list;

    public collectResponse(String type,List<T> list){
        this.type=type;
        this.list=list;
    }

}
