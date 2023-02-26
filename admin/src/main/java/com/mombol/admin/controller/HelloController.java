package com.mombol.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PathPatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.pattern.PathPattern;

import java.util.*;

@RestController
public class HelloController {

    @Autowired
    WebApplicationContext webApplicationContext;

    @GetMapping("/hello")
//    @PreAuthorize("@pms.hasPermission('pms:hello')")
    public String hello() {
        return "Hello, Welcome to admin!";
    }

    @GetMapping("allUrl")
    public List getAllUrl() {
        RequestMappingHandlerMapping mapping = webApplicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();

        List<Map<String, String>> list =new ArrayList<Map<String, String>>();

        for (Map.Entry<RequestMappingInfo, HandlerMethod> m: map.entrySet()) {
            Map<String, String> urlMap = new HashMap<String, String>();
            RequestMappingInfo info = m.getKey();
            HandlerMethod method = m.getValue();
            PathPatternsRequestCondition p = info.getPathPatternsCondition();

            for (PathPattern url : p.getPatterns()) {
                urlMap.put("url", url.toString());
            }

            urlMap.put("classname", method.getMethod().getDeclaringClass().getName());
            urlMap.put("name", method.getMethod().getName());
            RequestMethodsRequestCondition methodsCondition = info.getMethodsCondition();

            Set<RequestMethod> methods = methodsCondition.getMethods();

            for (RequestMethod requestMethod : methods) {
                urlMap.put("type", requestMethod.toString());
            }

            list.add(urlMap);
        }

        return list;
    }

}
