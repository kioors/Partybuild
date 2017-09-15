package com.kingyon.partybuild.repositories;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.partybuild.domain.learnset.Article;
import com.kingyon.partybuild.domain.learnset.Education;
import com.kingyon.partybuild.domain.learnset.UserOperationCount;
import com.kingyon.partybuild.domain.learnset.Video;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Machenike on 2017/9/14.
 */
public interface LikesRepository extends CacheRepository<UserOperationCount, Long> {

    @Query(value = "select u from UserOperationCount u where deleted = false and userId = ?1 and num_type=?2 limit ?3,?4", nativeQuery = true)
    public List<UserOperationCount> getUserOperationCountByUid(Long Source_id, int type, int page, int size);


    @Query(value = "select a from Article a where deleted = false and userId = ?1")
    public List<Article> getArticles(Long userId);

    @Query(value = "select e from Education e where deleted = false and userId = ?1")
    public List<Education> getEducations(Long userId);

    @Query(value = "select v from Video v where deleted = false and userId = ?1")
    public List<Video> getVideos(Long userId);

    @Query(value = "select a from Article a where deleted = false and createAccountId = ?1")
    Article getArticle(Long userId);
}
