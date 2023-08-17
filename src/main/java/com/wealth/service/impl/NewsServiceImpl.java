package com.wealth.service.impl;

import com.wealth.entity.News;
import com.wealth.mapper.NewsMapper;
import com.wealth.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: StudentManager
 * @author: iamYBG
 * @description:
 * @create: 2021-12-06
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Value("${page.newsPageNum}")
    private Integer pageNum;

    @Override
    public List<News> getNewsByPage(Integer page) {
        return newsMapper.getNewsByPage((page - 1) * pageNum, pageNum);
    }

    @Override
    public News getNews(Long id) {
        newsMapper.updateViews(id);
        return newsMapper.getNews(id);
    }

    @Override
    public Integer getNewsCount() {
        return newsMapper.getNewsCount();
    }
}
