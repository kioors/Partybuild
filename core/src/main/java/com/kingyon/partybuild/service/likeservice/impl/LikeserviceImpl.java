package com.kingyon.partybuild.service.likeservice.impl;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.common.services.impl.BaseService;
import com.kingyon.partybuild.domain.learnset.Article;
import com.kingyon.partybuild.domain.learnset.OperationType;
import com.kingyon.partybuild.domain.learnset.UserOperationCount;
import com.kingyon.partybuild.dto.LearnsetDto;
import com.kingyon.partybuild.repositories.ArticleRepository;
import com.kingyon.partybuild.repositories.LikesRepository;
import com.kingyon.partybuild.service.likeservice.Likeservice;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Machenike on 2017/9/14.
 */
@Service
public class LikeserviceImpl extends BaseService<UserOperationCount, Long> implements Likeservice {

    @Autowired
    private LikesRepository likesRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    protected CacheRepository<UserOperationCount, Long> getRepository() {
        return this.getRepository();
    }

    @Override
    public List<UserOperationCount> getUserOperationCount(Long userId, int page, int size, int type) {
        getRepository().findAll(new Sort(Sort.Direction.DESC));
        List<UserOperationCount> userOperationCounts = likesRepository.getUserOperationCountByUid(userId, type, page, size);
        if (CollectionUtils.isEmpty(userOperationCounts)) {

        }
        List<LearnsetDto> learnsetDtos = new ArrayList<>();

        for (UserOperationCount uc : userOperationCounts) {

            if (uc.getNumType() == OperationType.THUMBUP) {
                LearnsetDto learnsetDto = new LearnsetDto();
                Article art = articleRepository.getOne(uc.getSourceId());
                learnsetDto.setThumbUp(art.getThumbUp());
                learnsetDto.setTitle(art.getTitle());
                learnsetDto.setPageView(art.getPageView());
                learnsetDto.setType(0);
                learnsetDto.setCollection(art.getCollection());
                learnsetDto.setDate(art.getUpdatedDate());
                learnsetDto.setObjectId(art.getUpdateAccountId());
                learnsetDtos.add(learnsetDto);

            } else {
                return null;
            }
        }
        return userOperationCounts;
    }
}
