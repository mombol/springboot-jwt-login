package com.mombol.admin.security.config;

import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson2.JSON;
import com.mombol.admin.security.entity.AdminUserDetail;
import com.mombol.common.response.ResponseBodyEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        ResponseBodyEntity responseBodyEntity = new ResponseBodyEntity();
        responseBodyEntity.setCode("001");
        responseBodyEntity.setMessage("Login Success!");

        Map<String, Object> resultData = new HashMap<>();
        Map<String, Object> tokenData = new HashMap<>();

        AdminUserDetail adminUserDetail = (AdminUserDetail)authentication.getPrincipal();
        tokenData.put("username", adminUserDetail.getUsername());
        String token = JWTUtil.createToken(tokenData, "_SECRET_".getBytes());
        resultData.put("token", token);
        responseBodyEntity.setData(resultData);

        response.getWriter().write(JSON.toJSONString(responseBodyEntity));
    }
}
