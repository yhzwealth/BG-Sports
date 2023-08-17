package com.wealth.service;

import com.wealth.entity.News;

import java.util.List;

public interface NewsService {
    List<News> getNewsByPage(Integer page);
    News getNews(Long id);
    Integer getNewsCount();
}
