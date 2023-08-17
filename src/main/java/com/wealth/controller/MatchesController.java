package com.wealth.controller;

import com.wealth.service.MatchesService;
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
@RequestMapping("/match")
public class MatchesController {

    @Autowired
    private MatchesService matchesService;

    @PostMapping("/unOver")
    public Result getUnOver(String type,Integer page){
        return Result.success(matchesService.getUnCompleteMatch(type,page));
    }

    @PostMapping("/home")
    public Result getUnOver2(){
        return Result.success(matchesService.getUnCompleteMatch());
    }

    @PostMapping("/unOverCount")
    public Result getUnOverCount(String type){
        return Result.success(matchesService.getUnCompleteMatchCount(type));
    }

    @PostMapping("/over")
    public Result getOver(String type,Integer page){
        return Result.success(matchesService.getCompleteMatch(type,page));
    }

    @PostMapping("/overCount")
    public Result getOverCount(String type){
        return Result.success(matchesService.getCompleteMatchCount(type));
    }

    @PostMapping("/get")
    public Result getOne(Long id){
        return Result.success(matchesService.getMatch(id));
    }
}
