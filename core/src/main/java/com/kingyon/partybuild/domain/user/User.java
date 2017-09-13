package com.kingyon.partybuild.domain.user;

import com.kingyon.common.domain.AuditedDomain;
import com.kingyon.common.domain.account.Login;
import com.kingyon.common.domain.authorization.Resource;
import com.kingyon.common.domain.authorization.Role;
import com.kingyon.partybuild.domain.party.Party;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "S_USER")
public class User extends AuditedDomain implements Login {

    /**
     *
     */
    public String name;

    /**
     *
     */
    public String phone;

    /**
     * 头像
     */
    public String head;

    /**
     * 身份
     */
    public IdentityType identity;

    /**
     * 所属
     */
    public Party affilication;

    /**
     * 入党时间
     */
    @Column(name = "party_date")
    public Date partyDate;

    /**
     *
     */
    public String password;

    /**
     * 绑定账号和手机的机器码
     */
    @Column(name = "device_id")
    public String deviceId;

    /**
     * 登录名
     */
    @Column(nullable = false)
    private String mobile;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public IdentityType getIdentity() {
        return identity;
    }

    public void setIdentity(IdentityType identity) {
        this.identity = identity;
    }

    public Party getAffilication() {
        return affilication;
    }

    public void setAffilication(Party affilication) {
        this.affilication = affilication;
    }

    public Date getPartyDate() {
        return partyDate;
    }

    public void setPartyDate(Date partyDate) {
        this.partyDate = partyDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
