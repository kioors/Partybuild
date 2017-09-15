package com.kingyon.partybuild.service.collect;

import com.kingyon.common.services.IBaseService;
import com.kingyon.partybuild.domain.learnset.Article;
import com.kingyon.partybuild.domain.learnset.Education;
import com.kingyon.partybuild.domain.learnset.UserOperationCount;
import com.kingyon.partybuild.domain.learnset.Video;
import com.kingyon.partybuild.dto.LearnsetDto;

import java.util.List;

/**
 * 描述
 * <p/>
 *
 * @author <a href="Abel@kingyon.com">Abel</a>
 * 2017/9/14
 * @since 0.1.0
 */
public interface ICollectService extends IBaseService<UserOperationCount,Long> {

     List<LearnsetDto> getUserOperationCountList(int size,int page,int type,Long source_id);

     List<Article> getArticleList(Long source_id);

     List<Education> getEducationList(Long source_id);

     List<Video> getVideoList(Long source_id);
}
