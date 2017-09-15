package com.kingyon.partybuild.repositories;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.partybuild.domain.learnset.LoopImages;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SlideshowRepository extends CacheRepository<LoopImages, Long> {

    @Query("select li from LoopImages li where li.deleted = false order by li.id desc")
    public List<LoopImages> getLoopImages();


}
