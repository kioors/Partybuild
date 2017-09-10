package com.kingyon.partybuild.repositories;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.partybuild.domain.DemoBean;
import com.kingyon.partybuild.domain.user.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DemoRepository extends CacheRepository<DemoBean, Long> {

    @Query(value = "select d from DemoBean d where d.deleted = false and d.name = ?1")
    List<DemoBean> findDemoBeanByName(String name);
}
