package com.wealth.controller;

import com.wealth.security.SimpleGrantedAuthority;
import com.wealth.service.BetService;
import com.wealth.service.UserService;
import com.wealth.utils.MissionCheck;
import com.wealth.utils.Result;
import com.wealth.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @program: StudentManager
 * @author: iamYBG
 * @description:
 * @create: 2021-12-06
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BetService betService;

    @PostMapping("/signUp")
    public Result signUp(String username, String password, String nickname, String invite) {
        if (userService.checkUsername(username) == 0) {
            userService.signUp(username, password, nickname,invite);
            return Result.success();
        }
        return Result.error("该用户名已被使用");
    }

    @PostMapping("/changePwd")
    public Result changePwd(String oldPwd, String newPwd){
        String username = SecurityUtils.getCurrentUsername();
        if (username != null) {
            if(userService.checkPwd(username, oldPwd) == 1){
                userService.changePwd(username, newPwd);
                return Result.success();
            }else{
                return Result.error("旧密码输入错误");
            }
        }
        return Result.error("未登录");
    }

    @PostMapping("/getInfo")
    public Result getInfo() {
        String username = SecurityUtils.getCurrentUsername();
        System.out.println("username=" + username);
        if (username != null) {
            return Result.success(userService.getUserInfo(username).setPassword(null));
        }
        return Result.error("未登录");
    }

    @PostMapping("/avatar")
    public Result changeAvatar(String url){
        String username = SecurityUtils.getCurrentUsername();
        if(username != null){
            Set<SimpleGrantedAuthority> authorities = SecurityUtils.getCurrentPermissions();
            if(!authorities.contains(new SimpleGrantedAuthority("vip"))){
                return Result.error(403,"无权限",null);
            }
            userService.changeAvatar(username,url);
            return Result.success();
        }
        return Result.error("未登录");
    }

    @PostMapping("/newsRead")
    public Result readNews() {
        String username = SecurityUtils.getCurrentUsername();
        if (username != null) {
            userService.updateViews(username);
            Integer views = userService.getUserInfo(username).getTodayViews();
            if (views == 10) {
                userService.updateCoins(username, 5);
            }
            return Result.success(views);
        }
        return Result.error("登录状态已过期");
    }

    @PostMapping("/getMission")
    public Result getMission() {
        String username = SecurityUtils.getCurrentUsername();
        if (username != null) {
            boolean m2 = false;
            boolean m3 = false;
            if (userService.getUserInfo(username).getTodayViews() > 9) {
                m2 = true;
            }
            if (betService.countTodayBet(username) > 0) {
                m3 = true;
            }
            return Result.success(MissionCheck.check(m2, m3));
        }
        return Result.error("登录状态已过期");
    }
}
