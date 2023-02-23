package com.mombol.security.common.config;

import com.mombol.security.common.adapter.AuthConfigAdapter;
import com.mombol.security.common.adapter.DefaultAuthConfigAdapter;
import com.mombol.security.common.filter.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import javax.servlet.DispatcherType;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class AuthConfig {

    @Autowired
    private AuthFilter authFilter;

    @Bean
    @ConditionalOnMissingBean
    public AuthConfigAdapter authConfigAdapter() {
        return new DefaultAuthConfigAdapter();
    }

    @Bean
    @Lazy
    public FilterRegistrationBean<AuthFilter> filterFilterRegistrationBean(AuthConfigAdapter authConfigAdapter) {
        FilterRegistrationBean<AuthFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(authFilter);
        filterFilterRegistrationBean.setName("authFilter");
        filterFilterRegistrationBean.setOrder(0);
        filterFilterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST);

        return filterFilterRegistrationBean;
    }

}
