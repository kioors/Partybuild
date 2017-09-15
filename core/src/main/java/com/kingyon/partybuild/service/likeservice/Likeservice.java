package com.kingyon.partybuild.service.likeservice;

import com.kingyon.common.services.IBaseService;
import com.kingyon.partybuild.domain.learnset.UserOperationCount;
import com.kingyon.partybuild.dto.LearnsetDto;

import java.util.List;

/**
 * Created by Machenike on 2017/9/14.
 */
public interface Likeservice extends IBaseService<UserOperationCount, Long> {

    List<LearnsetDto> getUserOperationCount(Long userId, int page, int size, int type);


    List<LearnsetDto> getArticles(Long userId);

    List<LearnsetDto> getEducations(Long userId);

    List<LearnsetDto> getVideos(Long ueserId);
}
