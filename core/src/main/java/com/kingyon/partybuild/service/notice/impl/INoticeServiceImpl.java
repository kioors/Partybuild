package com.kingyon.partybuild.service.notice.impl;

import com.kingyon.partybuild.common.NullParamException;
import com.kingyon.partybuild.domain.notice.Notice;
import com.kingyon.partybuild.domain.notice.NoticeState;
import com.kingyon.partybuild.dto.NoticeDto;
import com.kingyon.partybuild.repositories.NoticeRepository;
import com.kingyon.partybuild.service.notice.INoticeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service(value = "noticeService")
@Transactional(readOnly = true)
public class INoticeServiceImpl implements INoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    @Transactional
    public void deleteNotice(long noticeId) throws NullPointerException {
        Notice notice = noticeRepository.findOne(noticeId);
        if (notice == null) {
            throw new NullPointerException();
        }
        notice.setDeleted(true);
    }

    @Override
    @Transactional
    public void modifyNotice(Long noticeId, String title, String detail) throws NullParamException, NullPointerException {
        if (StringUtils.isEmpty(title) || StringUtils.isEmpty(detail)) {
            throw new NullParamException();
        }
        Notice notice = noticeRepository.findOne(noticeId);
        if (notice == null || notice.getDeleted()) {
            throw new NullPointerException();
        }
        notice.setTitle(title);
        notice.setDetail(detail);
        notice.setUpdateAccountId(1L);
        notice.setUpdatedDate(new Date());
    }

    @Override
    public NoticeDto getNotice(Long noticeId) throws NullPointerException {
        Notice notice = noticeRepository.findOne(noticeId);
        if (notice == null) {
            throw new NullPointerException();
        }
        // 用实体类封装
        NoticeDto data = new NoticeDto();
        data.setId(notice.getId());
        data.setTitle(notice.getTitle());
        data.setDetail(notice.getDetail());
        data.setStateName(NoticeState.getStateName(notice.getState()));
        data.setState(notice.getState());
        return data;
    }

    @Override
    @Transactional
    public void addNotice(String title, String detail) throws NullParamException {
        if (StringUtils.isEmpty(title) || StringUtils.isEmpty(detail)) {
            throw new NullParamException();
        }
        Notice notice = new Notice();
        notice.setDate(new Date()); // 发布时间
        notice.setTitle(title); // 标题
        notice.setDetail(detail); // 公告详情
        notice.setCreatedDate(new Date()); // 创建时间
        notice.setDeleted(false); // 是否删除
        notice.setEnable(true); // 是否启用
        notice.setUpdatedDate(new Date()); // 修改时间
        notice.setCreateAccountId(1L); // 创建者ID
        notice.setUpdateAccountId(1L); // 修改者ID
        notice.setState(NoticeState.notRelease.getState()); //  新增数据默认状态为待发布
        noticeRepository.save(notice);
    }
}
