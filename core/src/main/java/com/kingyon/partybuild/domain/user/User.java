package com.kingyon.partybuild.domain.user;

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

/**
 * User为运营中心（即后台）的账号
 * <p/>
 *
 * @author <a href="libing@kingyon.com">Libing Huang</a>
 * 2017/7/13 上午11:07
 * @since 0.1.0
 */
@Entity
@Table(name = "S_USER")
public class User extends AuditedDomain implements Login {

    private String name;
    @Column(nullable = false)
    private String mobile;

    //登录密码
    private String password;

    //账号权限
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "K_USER_ROLE", joinColumns = {@JoinColumn(name = "account_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;

    //为用户直接赋予的资源
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(name = "K_USER_RESOURCE", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "resource_id")})
    private Set<Resource> resources;

    //********************** Domain method **********************//

    public User() {
    }

    public User(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    /**
     * 如何获取账号的权限，一般项目情况仅在运维或者后台才会出现
     * 那么这个方法的实现可以由子类去实现
     * 用户的权限是由直接赋予的资源和所拥有的Role组成的
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : this.roles) {
            Set<Resource> resources = role.getResources();
            for (Resource resource : resources) {
                authorities.add(new SimpleGrantedAuthority(resource.getCode()));
            }
        }
        for (Resource resource : resources) {
            authorities.add(new SimpleGrantedAuthority(resource.getCode()));
        }
        return authorities;
    }

    /**
     * 获取真实姓名
     *
     * @return
     */
    @Override
    public String getNickname() {
        return this.name;
    }


    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * 根据项目的情况，可能会出现登陆账号的形式不一样（Email\Mobile)
     * - 在子类中直接重字此方法
     *
     * @return
     */
    @Override
    public String getUsername() {
        return this.mobile;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return getEnable();
    }

    //********************** Getter and Setter **********************//

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }
}
