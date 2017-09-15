package com.kingyon.partybuild.service.slideshow;

import com.kingyon.common.services.IBaseService;
import com.kingyon.partybuild.domain.learnset.LoopImages;
import com.kingyon.partybuild.dto.api.ApiSlideshowDto;

import java.util.List;

public interface ISlideshowService extends IBaseService<LoopImages, Long> {

    public List<ApiSlideshowDto> getSlideshow();

}
