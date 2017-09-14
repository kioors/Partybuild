package com.kingyon.partybuild.service.collect.impl;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.common.services.impl.BaseService;
import com.kingyon.partybuild.domain.learnset.UserOperationCount;
import com.kingyon.partybuild.repositories.ColllectReponsitory;
import com.kingyon.partybuild.service.collect.ICollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    @Override
    protected CacheRepository<UserOperationCount, Long> getRepository() {
        return colllectReponsitory;
    }


}
