package com.mombol.admin.security.config;

import com.mombol.admin.security.filter.JwtAuthenticateFilter;
import com.mombol.security.common.config.WebSecurityForAjaxConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@Configuration
public class AdminWebSecurityConfig extends WebSecurityForAjaxConfig {

    @Autowired
    AjaxAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    AjaxAuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    AjaxAuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    JwtAuthenticateFilter jwtAuthenticateFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint);
        setHttpSecurity(httpSecurity);
        httpSecurity.formLogin()
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .permitAll();

        httpSecurity.addFilterBefore(jwtAuthenticateFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}
