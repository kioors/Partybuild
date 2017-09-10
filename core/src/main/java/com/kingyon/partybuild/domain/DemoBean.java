package com.kingyon.partybuild.domain;

import com.kingyon.common.domain.AuditedDomain;
import com.kingyon.common.domain.account.Login;
import com.kingyon.common.domain.authorization.Resource;
import com.kingyon.common.domain.authorization.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "S_DEMO")
public class DemoBean extends AuditedDomain {

    private String code;

    private String name;

    //********************** Domain method **********************//

    public DemoBean() {
    }

    public DemoBean(String code, String name) {
        this.code = code;
        this.name = name;
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
}
