package com.kingyon.partybuild.service.notice;

import com.kingyon.partybuild.common.NullParamException;
import com.kingyon.partybuild.dto.NoticeDto;

public interface INoticeService {

    /**
     * 添加公告，返回公告ID
     *
     * @param title
     * @param content
     * @return
     */
    public void addNotice(String title, String content) throws NullParamException;

    /**
     * 删除公告，传入公告ID，返回删除成功的数量，如果返回0则代表删除失败
     *
     * @param noticeId
     * @return
     */
    public void deleteNotice(long noticeId) throws NullPointerException;

    /**
     * 修改公告信息，传入公告ID标题内容等信息，返回修改成功的数量
     *
     * @param noticeId
     * @param title
     * @param content
     * @return
     */
    public void modifyNotice(Long noticeId, String title, String content) throws NullParamException, NullPointerException;

    /**
     * 根据ID获取公告信息，返回一个MAP，封装前台所需要的数据，如：时间，标题，内容等数据
     *
     * @param id
     * @return
     */
    public NoticeDto getNotice(Long id) throws NullPointerException;

}
