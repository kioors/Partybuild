package com.kingyon.partybuild.service.slideshow.impl;

import com.kingyon.common.repositories.CacheRepository;
import com.kingyon.common.services.impl.BaseService;
import com.kingyon.partybuild.domain.learnset.LoopImages;
import com.kingyon.partybuild.dto.api.ApiSlideshowDto;
import com.kingyon.partybuild.repositories.SlideshowRepository;
import com.kingyon.partybuild.service.slideshow.ISlideshowService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "slideshowService")
@Transactional(readOnly = true)
public class SlideshowService extends BaseService<LoopImages, Long> implements ISlideshowService {

    @Autowired
    private SlideshowRepository slideshowRepository;

    @Override
    protected CacheRepository<LoopImages, Long> getRepository() {
        return slideshowRepository;
    }

    @Override
    public List<ApiSlideshowDto> getSlideshow() {
        List<LoopImages> imgs = slideshowRepository.getLoopImages();
        if (CollectionUtils.isEmpty(imgs)) {
            return new ArrayList<ApiSlideshowDto>();
        }
        List<ApiSlideshowDto> datas = new ArrayList<ApiSlideshowDto>();
        for (LoopImages img : imgs) {
            if (img.getLoopImage() == null)
                continue;
            datas.add(new ApiSlideshowDto(img.getLoopImage().getUrl(), img.getSourceId(), img.getSourceType().getType()));
        }
        return datas;
    }
}
