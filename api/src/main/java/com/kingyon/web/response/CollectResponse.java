package com.kingyon.web.response;

import com.kingyon.partybuild.dto.LearnsetDto;

import java.util.Date;
import java.util.List;

/**
 * 描述
 * <p/>
 *
 * @author <a href="Abel@kingyon.com">Abel</a>
 * 2017/9/14
 * @since 0.1.0
 */
public class CollectResponse {

    private  List<LearnsetDto> learnsetDtoList;
    //当前页数
    private  Integer Size;
    //总条数
    private  Integer totalElements;
    //总页数
    private  Integer totalPagesl;

    public List<LearnsetDto> getLearnsetDtoList() {
        return learnsetDtoList;
    }

    public void setLearnsetDtoList(List<LearnsetDto> learnsetDtoList) {
        this.learnsetDtoList = learnsetDtoList;
    }

    public Integer getSize() {
        return Size;
    }

    public void setSize(Integer size) {
        Size = size;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getTotalPagesl() {
        return totalPagesl;
    }

    public void setTotalPagesl(Integer totalPagesl) {
        this.totalPagesl = totalPagesl;
    }
}
