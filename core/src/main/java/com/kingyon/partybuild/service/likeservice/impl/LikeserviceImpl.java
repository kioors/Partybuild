package com.kingyon.partybuild.service.likeservice.impl;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.common.services.impl.BaseService;
import com.kingyon.partybuild.domain.learnset.Article;
import com.kingyon.partybuild.domain.learnset.SourceType;
import com.kingyon.partybuild.domain.learnset.UserOperationCount;
import com.kingyon.partybuild.dto.LearnsetDto;
import com.kingyon.partybuild.dto.method.LearnsetDtoMethod;
import com.kingyon.partybuild.repositories.LikesRepository;
import com.kingyon.partybuild.service.likeservice.Likeservice;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Machenike on 2017/9/14.
 */
@Service
@Transactional(readOnly = true)
public class LikeserviceImpl extends BaseService<UserOperationCount, Long> implements Likeservice {

    @Autowired
    private LikesRepository likesRepository;

    private LearnsetDtoMethod learnsetDtoMethod = new LearnsetDtoMethod();

    @Override
    protected CacheRepository<UserOperationCount, Long> getRepository() {
        return this.getRepository();
    }

    @Override
    public List<LearnsetDto> getUserOperationCount(Long userId, int page, int size, int type) {
        getRepository().findAll(new Sort(Sort.Direction.DESC));
        List<LearnsetDto> learnsetDtos = new ArrayList<>();

        List<UserOperationCount> userOperationCounts = likesRepository.getUserOperationCountByUid(userId, type, page, size);

        if (CollectionUtils.isEmpty(userOperationCounts)) {
            throw new NullPointerException();
        }


        for (UserOperationCount uc : userOperationCounts) {
            if (uc.getSourceType() == SourceType.ARTICLE) {
                learnsetDtos.addAll(getArticles(userId));
            } else if (uc.getSourceType() == SourceType.ENCLOSURE) {
                learnsetDtos.addAll(getEducations(userId));
            } else if (uc.getSourceType() == SourceType.VIDEO) {
                learnsetDtos.addAll(getVideos(userId));
            }
        }
        return learnsetDtos;
    }

    @Override
    public Article getAricle(Long userId) {
        return null;
    }


    @Override
    @Transactional
    public List<LearnsetDto> getArticles(Long userId) {
        return learnsetDtoMethod.getArticle(likesRepository.getArticles(userId));
    }

    @Override
    @Transactional
    public List<LearnsetDto> getEducations(Long userId) {
        return learnsetDtoMethod.getEducation(likesRepository.getEducations(userId));
    }

    @Override
    @Transactional
    public List<LearnsetDto> getVideos(Long ueserId) {
        return learnsetDtoMethod.getVideo(likesRepository.getVideos(ueserId));
    }
}
