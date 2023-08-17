package com.wealth.security.handle;

import com.alibaba.fastjson.JSONObject;
import com.wealth.entity.User;
import com.wealth.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpStatus.OK.value());
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, x-content-type-options");
        httpServletResponse.setHeader("Access-Control-Expose-Headers", "Content-Disposition");

        PrintWriter writer = httpServletResponse.getWriter();
        UserDetails principal = (UserDetails) authentication.getPrincipal();

        userMapper.updateLoginCoins(principal.getUsername());
        User user = userMapper.getInfo(principal.getUsername()).setPassword(null);
        userMapper.updateLoginTime(principal.getUsername());

        writer.write(JSONObject.toJSONStringWithDateFormat(user,"yyyy-MM-dd HH:mm:ss"));
        writer.flush();
        writer.close();
    }
}