package com.wealth.mapper;

import com.wealth.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User getInfo(String username);
    void updateCoins(String username, Integer coin);
    void updateLoginCoins(String username);
    void updateLoginTime(String username);
    void updateViews(String username);
    Integer checkUsername(String username);
    void insertUser(@Param("user") User user);
    Integer checkPwd(String username, String oldPwd);
    void changePwd(String username, String newPwd);
    void changeAvatar(String username, String url);
}
