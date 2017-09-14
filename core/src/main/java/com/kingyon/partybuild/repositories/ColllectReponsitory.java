package com.kingyon.partybuild.repositories;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.partybuild.domain.learnset.UserOperationCount;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 描述
 * <p/>
 *
 * @author <a href="jorge@kingyon.com">Jorge</a>
 * 2017/9/14
 * @since 0.1.0
 */
public interface ColllectReponsitory extends CacheRepository<UserOperationCount,Long> {

    @Query(value = "select u from UserOperationCount as u where deleted = false and userId = ?1 and num_type=?2 limit ?3,?4")
    public List<UserOperationCount> getUserOperationCountByUid(Long userId, int type, int page, int size);

}
