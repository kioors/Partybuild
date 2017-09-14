package com.kingyon.web.response;

import java.util.List;

/**
 * 描述
 * <p/>
 *
 * @author <a href="Abel@kingyon.com">Abel</a>
 * 2017/9/14
 * @since 0.1.0
 */
public class CollectResponse<T>{

    private Integer type;

    private List<T> returstList;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List getReturstList() {
        return returstList;
    }

    public void setReturstList(List returstList) {
        this.returstList = returstList;
    }
}
