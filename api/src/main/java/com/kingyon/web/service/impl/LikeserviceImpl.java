package com.kingyon.web.service.impl;

import com.kingyon.partybuild.domain.learnset.Article;
import com.kingyon.partybuild.domain.learnset.Education;
import com.kingyon.partybuild.domain.learnset.Video;
import com.kingyon.partybuild.dto.UserDto;
import com.kingyon.web.service.Likeservice;

import java.util.ArrayList;
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
    public List<UserDto> getLikeList(List<Article> articles, List<Education> educations, List<Video> videos) {
        List<UserDto> userDtos = new ArrayList<>();
        for (Article article: articles) {
            UserDto userDto = new UserDto();
            userDto.setCollection(article.getCollection());
            userDto.setDate();
        }
        return null;
    }
}
