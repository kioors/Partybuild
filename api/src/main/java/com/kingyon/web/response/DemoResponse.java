package com.kingyon.web.response;

import com.kingyon.common.response.IdentitiableObject;
import com.kingyon.partybuild.domain.DemoBean;
import io.swagger.annotations.ApiModelProperty;

/**
 * ${DESCRIPTION}
 * <p/>
 *
 * @author <a href="libing@kingyon.com">Libing Huang</a>
 *         2017/8/8 上午11:47
 * @since 0.1.0
 */
public class DemoResponse extends IdentitiableObject {

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "编码")
    private String code;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "是否删除")
    private Boolean deleted;

    //********************** Domain method **********************//

    public DemoResponse() {
    }

    public DemoResponse(DemoBean demoBean) {
        setId(demoBean.getId());
        setCode(demoBean.getCode());
        setName(demoBean.getName());
        setDeleted(demoBean.getDeleted());
    }


    //********************** Getter and Setter **********************//


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}

