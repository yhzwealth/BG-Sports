package com.wealth.controller;

import com.wealth.po.BetPo;
import com.wealth.service.BetService;
import com.wealth.utils.Result;
import com.wealth.utils.SecurityUtils;
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
@RequestMapping("/bet")
public class BetController {

    @Autowired
    private BetService betService;

    @PostMapping("/get")
    public Result getInfo(Integer page) {
        String username = SecurityUtils.getCurrentUsername();
        if (username != null) {
            return Result.success(betService.getBetInfo(username, page));
        }
        return Result.error("登录信息已失效");
    }

    @PostMapping("/getCount")
    public Result getCount() {
        String username = SecurityUtils.getCurrentUsername();
        if (username != null) {
            return Result.success(betService.getBetCount(username));
        }
        return Result.error("登录信息已失效");
    }

    @PostMapping("/getRare")
    public Result getRare(Long id){
        String username = SecurityUtils.getCurrentUsername();
        if (username != null) {
            return Result.success(betService.getRare(id));
        }
        return Result.error("登录信息已失效");
    }

    @PostMapping("/bet")
    public Result bet(BetPo po){
        String username = SecurityUtils.getCurrentUsername();
        if (username != null) {
            po.setUsername(username);
            if(betService.bet(po))
                return Result.success();
            else
                return Result.error(501,"赔率已过期",null);
        }
        return Result.error("登录信息已失效");
    }
}
