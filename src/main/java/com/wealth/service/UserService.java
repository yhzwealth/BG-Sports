package com.wealth.service;

import com.wealth.entity.User;

public interface UserService {
    User getUserInfo(String username);
    void updateViews(String username);
    void updateCoins(String username, Integer coins);
    Integer checkUsername(String username);
    void signUp(String username,String password,String nickname, String invite);
    Integer checkPwd(String username, String oldPwd);
    void changePwd(String username, String newPwd);
    void changeAvatar(String username, String url);
}
