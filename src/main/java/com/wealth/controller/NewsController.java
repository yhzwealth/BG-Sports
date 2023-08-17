package com.wealth.controller;

import com.wealth.service.NewsService;
import com.wealth.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: StudentManager
 * @author: iamYBG
 * @description:
 * @create: 2021-12-06
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @PostMapping("/getAll")
    public Result getAll(Integer page){
        return Result.success(newsService.getNewsByPage(page));
    }

    @PostMapping("/get")
    public Result get(Long id){
        return Result.success(newsService.getNews(id));
    }

    @PostMapping("/getCount")
    public Result get(){
        return Result.success(newsService.getNewsCount());
    }
}
