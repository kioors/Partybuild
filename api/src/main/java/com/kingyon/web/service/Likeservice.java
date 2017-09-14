package com.kingyon.web.service;

import com.kingyon.partybuild.domain.learnset.Article;
import com.kingyon.partybuild.domain.learnset.Education;
import com.kingyon.partybuild.domain.learnset.Video;

import java.util.List;

/**
 * Created by Machenike on 2017/9/14.
 */
public interface Likeservice {

    List<Article> getLikeArticle (String userName);

    List<Education> getLikeEducation (String userName);

    List<Video> getLikeVideo(String userName);
}
