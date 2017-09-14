package com.kingyon.partybuild.service.likeservice;

import com.kingyon.common.services.IBaseService;
import com.kingyon.partybuild.domain.learnset.UserOperationCount;

import java.util.List;

/**
 * Created by Machenike on 2017/9/14.
 */
public interface Likeservice extends IBaseService<UserOperationCount, Long> {

    List<UserOperationCount> getUserOperationCount(Long userId, int page, int size, int type);

}
