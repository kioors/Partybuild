package com.kingyon.partybuild.service.collect.impl;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.common.services.impl.BaseService;
import com.kingyon.partybuild.domain.learnset.Article;
import com.kingyon.partybuild.domain.learnset.Education;
import com.kingyon.partybuild.domain.learnset.UserOperationCount;
import com.kingyon.partybuild.domain.learnset.Video;
import com.kingyon.partybuild.dto.LearnsetDto;
import com.kingyon.partybuild.dto.method.LearnsetDtoMethod;
import com.kingyon.partybuild.repositories.ColllectReponsitory;
import com.kingyon.partybuild.service.collect.ICollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 描述
 * <p/>
 *
 * @author <a href="Abel@kingyon.com">Abel</a>
 * 2017/9/14
 * @since 0.1.0
 */
@Service("CollectService")
@Transactional(readOnly = true)
public class ICollectServiceImpl extends BaseService<UserOperationCount,Long> implements ICollectService {

    @Autowired
    private ColllectReponsitory colllectReponsitory;

    private LearnsetDtoMethod learnsetDtoMethod = new LearnsetDtoMethod();
    @Override
    protected CacheRepository<UserOperationCount, Long> getRepository() {
        return colllectReponsitory;
    }


    @Override
    public List<LearnsetDto> getUserOperationCountList(int size, int page, int type, Long source_id) {
        return null;
    }

    @Override
    public List<Article> getArticleList(Long source_id) {
        return null;
    }

    @Override
    public List<Education> getEducationList(Long source_id) {
        return null;
    }

    @Override
    public List<Video> getVideoList(Long source_id) {
        return null;
    }
}
