package com.kingyon.partybuild.domain.member;

import com.kingyon.common.domain.AuditedDomain;
import com.kingyon.common.domain.Gender;
import com.kingyon.partybuild.domain.attachment.PictureAttachment;

import javax.persistence.*;

/**
 * 用户
 * <p/>
 *
 * @author <a href="libing@kingyon.com">Libing Huang</a>
 * 2017/8/7 下午8:18
 * @since 0.1.0
 */
@Entity
@Table(name = "S_MEMBER")
public class Member extends AuditedDomain {

    private String mobile;
    private String name;
    //性别
    @Enumerated(EnumType.STRING)
    private Gender gender;
    //头像
    @ManyToOne
    private PictureAttachment avatar;
    private String city;
    @Column(nullable = false)
    private String openid;


    //********************** Domain method **********************//

    public Member() {

    }

    public Member(String openid, String nickname, Gender gender) {
        this.openid = openid;
        this.name = nickname;
        this.gender = gender;
    }

    public Member(Long id) {
        this.setId(id);
    }

    //********************** Getter and Setter **********************//

    public PictureAttachment getAvatar() {
        return avatar;
    }

    public void setAvatar(PictureAttachment avatar) {
        this.avatar = avatar;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
