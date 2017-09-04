package com.kingyon.partybuild.support.service;


import com.kingyon.partybuild.model.MemberModel;

/**
 * 用户接口.
 * <p/>
 *
 * @author <a href="sam@kingyon.com">Yang Xiang</a>
 * 2017/5/23
 * @since 0.1.0
 */
public interface IRestSecurityService {

    /**
     * <p>客户端登录</p>
     *
     * @param id 用户账号对象id
     * @return 用户token
     */
    String login(Long id);

    /**
     * <p>客戶端登出</p>
     *
     * @param token 客户端会话token
     */
    void logout(String token);

    /**
     * <p>客戶端登出</p>
     *
     * @param id 客户端用户id
     */
    void logout(Long id);

    /**
     * <p>根据客户端会话token，返回当前已登录的用户账号。如果未登录或则返回null</p>
     *
     * @param token 客户端会话token
     * @return 已登录的用户账号
     */
    MemberModel getUserByToken(String token);

    /**
     * 返回当前已登录的用户账号id，如果未登录或则返回null
     *
     * @param token 客户端会话token
     * @return 已登录的用户账号id
     */
    Long getUserIdByToken(String token);

    /**
     * 更加微信openid获取用户
     *
     * @param openId
     * @return
     */
    MemberModel getUserByOpenId(String openId);
}
