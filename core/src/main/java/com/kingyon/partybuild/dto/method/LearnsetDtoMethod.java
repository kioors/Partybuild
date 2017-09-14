package com.kingyon.partybuild.dto.method;

import com.kingyon.partybuild.domain.learnset.Article;
import com.kingyon.partybuild.domain.learnset.Education;
import com.kingyon.partybuild.domain.learnset.Video;
import com.kingyon.partybuild.dto.LearnsetDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Machenike on 2017/9/14.
 */
public class LearnsetDtoMethod {

    public List<LearnsetDto> getLikeList(List<Article> articles, List<Education> educations, List<Video> videos) {
        List<LearnsetDto> learnsetDtos = new ArrayList<>();
        learnsetDtos.addAll(getArticle(articles));
        learnsetDtos.addAll(getEducation(educations));
        learnsetDtos.addAll(getVideo(videos));
        return learnsetDtos;
    }

    private List<LearnsetDto> getArticle(List<Article> articles) {
        List<LearnsetDto> learnsetDtos = new ArrayList<>();
        for (Article article : articles) {
            LearnsetDto learnsetDto = new LearnsetDto();
            learnsetDto.setCollection(article.getCollection());
            learnsetDto.setImage(article.getHeadImage());
            learnsetDto.setPageView(article.getPageView());
            learnsetDto.setTitle(article.getTitle());
            learnsetDto.setType(0);
            learnsetDto.setThumbUp(article.getThumbUp());

            learnsetDtos.add(learnsetDto);
        }
        return learnsetDtos;
    }

    private List<LearnsetDto> getEducation(List<Education> educations) {
        List<LearnsetDto> learnsetDtos = new ArrayList<>();
        for (Education education : educations) {
            LearnsetDto learnsetDto = new LearnsetDto();
            learnsetDto.setCollection(education.getCollection());
            learnsetDto.setImage(education.getHeadImage());
            learnsetDto.setPageView(education.getPageView());
            learnsetDto.setTitle(education.getTitle());
            learnsetDto.setType(1);
            learnsetDto.setThumbUp(education.getThumbUp());

            learnsetDtos.add(learnsetDto);
        }
        return learnsetDtos;
    }

    ;

    private List<LearnsetDto> getVideo(List<Video> videos) {
        List<LearnsetDto> learnsetDtos = new ArrayList<>();
        for (Video video : videos) {
            LearnsetDto learnsetDto = new LearnsetDto();

            learnsetDto.setCollection(video.getCollection());
            learnsetDto.setImage(video.getHeadImage());
            learnsetDto.setPageView(video.getPageView());
            learnsetDto.setTitle(video.getTitle());
            learnsetDto.setType(2);
            learnsetDto.setThumbUp(video.getThumbUp());

            learnsetDtos.add(learnsetDto);
        }
        return learnsetDtos;
    }
}
