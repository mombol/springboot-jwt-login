package com.mombol.admin.security.filter;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.mombol.admin.security.entity.AdminUserDetail;
import com.mombol.admin.security.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

//@Component
public class JwtAuthenticateFilter extends OncePerRequestFilter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");

        if (!StringUtils.hasLength(token)) {
            filterChain.doFilter(request, response);
            SecurityContextHolder.clearContext();
            return;
        }

        try {
            JWT jwt = JWTUtil.parseToken(token);
            Object usernameClaim = jwt.getPayload("username");

            if (!Objects.isNull(usernameClaim)) {
                String username = usernameClaim.toString();

                AdminUserDetail adminUserDetail = (AdminUserDetail) userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        adminUserDetail,
                        null,
                        adminUserDetail.getAuthorities()
                );

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        } catch (Exception e) {
        }

        filterChain.doFilter(request, response);
    }
}
