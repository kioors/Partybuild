package com.kingyon.partybuild.model;

import com.kingyon.common.model.AccountModel;
import com.kingyon.partybuild.domain.member.Member;

/**
 * describe：前端用户类
 *
 * @author <a href="sam@kingyon.com">Yang Xiang</a>
 * 2017/7/17 13:38
 * @since 0.1.0
 */
public class MemberModel extends AccountModel {

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 头像
     */
    private String head;

    public MemberModel() {
    }

    public MemberModel(Member member) {

        setId(member.getId());

        setNickname(member.getName());

        setGender(member.getGender());

        setMobile(member.getMobile());
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
