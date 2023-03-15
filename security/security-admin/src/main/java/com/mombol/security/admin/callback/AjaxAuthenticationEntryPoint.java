package com.mombol.security.admin.callback;

import com.alibaba.fastjson2.JSON;
import com.mombol.security.admin.response.ResponseBodyEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseBodyEntity responseBodyEntity = new ResponseBodyEntity();
        responseBodyEntity.setCode("000");
        responseBodyEntity.setMessage("No Authenticated!");

        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        response.getWriter().write(JSON.toJSONString(responseBodyEntity));
    }
}
