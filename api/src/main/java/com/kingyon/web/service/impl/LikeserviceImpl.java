package com.kingyon.web.service.impl;

import com.kingyon.partybuild.domain.learnset.Article;
import com.kingyon.partybuild.domain.learnset.Education;
import com.kingyon.partybuild.domain.learnset.Video;
import com.kingyon.partybuild.dto.LearnsetDto;
import com.kingyon.partybuild.dto.method.LearnsetDtoMethod;
import com.kingyon.web.service.Likeservice;

import java.util.List;

/**
 * Created by Machenike on 2017/9/14.
 */
public class LikeserviceImpl implements Likeservice{

    @Override
    public List<Article> getLikeArticle(String userName) {
        return null;
    }

    @Override
    public List<Education> getLikeEducation(String userName) {
        return null;
    }

    @Override
    public List<Video> getLikeVideo(String userName) {
        return null;
    }

    @Override
    public List<LearnsetDto> getLearnsetDto(List<Article> articles, List<Education> educations, List<Video> videos) {
        LearnsetDtoMethod learnsetDtoMethod = new LearnsetDtoMethod();
        return learnsetDtoMethod.getLikeList(articles, educations, videos);
    }

}
