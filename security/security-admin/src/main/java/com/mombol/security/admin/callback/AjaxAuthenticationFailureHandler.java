package com.mombol.security.admin.callback;

import com.alibaba.fastjson2.JSON;
import com.mombol.security.admin.response.ResponseBodyEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler{

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        ResponseBodyEntity responseBodyEntity = new ResponseBodyEntity();
        responseBodyEntity.setCode("002");
        responseBodyEntity.setMessage("Login failed: " + exception.getMessage() + "!");

        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        response.getWriter().write(JSON.toJSONString(responseBodyEntity));
    }
}
