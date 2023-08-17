package com.wealth.service.impl;

import com.wealth.entity.User;
import com.wealth.mapper.UserMapper;
import com.wealth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: StudentManager
 * @author: iamYBG
 * @description:
 * @create: 2021-12-06
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfo(String username) {
        return userMapper.getInfo(username);
    }

    @Override
    public void updateViews(String username) {
        userMapper.updateViews(username);
    }

    @Override
    public void updateCoins(String username, Integer coins) {
        userMapper.updateCoins(username, coins);
    }

    @Override
    public Integer checkUsername(String username) {
        return userMapper.checkUsername(username);
    }


    @Override
    public void signUp(String username, String password, String nickname, String invite) {
        User user = new User().setUsername(username).setPassword(password)
                .setNickname(nickname).setAvatar("http://121.196.98.183:8080/img/default-avatar.jpg");
        if (invite == null)
            user.setRole("normal");
        else if (invite.equals("K1M01J"))
            user.setRole("vip");
        else if (invite.equals("I0516U"))
            user.setRole("admin");
        else
            user.setRole("normal");
        userMapper.insertUser(user);
    }

    @Override
    public Integer checkPwd(String username, String oldPwd) {
        return userMapper.checkPwd(username, oldPwd);
    }

    @Override
    public void changePwd(String username, String newPwd) {
        userMapper.changePwd(username, newPwd);
    }

    @Override
    public void changeAvatar(String username, String url) {
        userMapper.changeAvatar(username, url);
    }
}
