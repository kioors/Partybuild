package com.kingyon.web.response;

import com.kingyon.partybuild.domain.user.User;

/**
 * 描述
 * 返回个人资料
 * <p/>
 *
 * @author <a href="Able@kingyon.com">Abel</a>
 * 2017/9/15
 * @since 0.1.0
 */
public class PersonalResponse {

    public PersonalResponse(User user){

    }

    private String affiliation;//用户所属
    private String head;//头像链接
    private  String identity;//身份
    private String name	;//姓名
    private Long objectId;
    private long partyDate;
    private String phone;

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public long getPartyDate() {
        return partyDate;
    }

    public void setPartyDate(long partyDate) {
        this.partyDate = partyDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
