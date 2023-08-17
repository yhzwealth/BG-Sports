package com.wealth.service.impl;

import com.wealth.entity.User;
import com.wealth.mapper.UserMapper;
import com.wealth.security.SimpleGrantedAuthority;
import com.wealth.security.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author iamYBG
 * @since 2021-07-04
 */
@Service
public class SecurityUserServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserLogin user = new UserLogin();
        user.setUsername(s);
        User u = userMapper.getInfo(s);
        if(u == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        user.setPassword(u.getPassword());

        Set<SimpleGrantedAuthority> permissions = new HashSet<>();
        switch (u.getRole()) {
            case "admin":
                permissions.add(new SimpleGrantedAuthority("admin"));
                permissions.add(new SimpleGrantedAuthority("vip"));
                permissions.add(new SimpleGrantedAuthority("normal"));
                break;
            case "vip":
                permissions.add(new SimpleGrantedAuthority("vip"));
                permissions.add(new SimpleGrantedAuthority("normal"));
                break;
            case "normal":
                permissions.add(new SimpleGrantedAuthority("normal"));
                break;
        }
        System.out.println(permissions);
        user.setPermissions(permissions);
        return user;
    }
}