package com.mombol.security.admin.adapter;

import com.mombol.security.common.adapter.DefaultAuthConfigAdapter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ResourceAuthAdapter extends DefaultAuthConfigAdapter {
    public static final List<String> EXCLUDE_PATH_PATTERS = Arrays.asList(
            "/swagger/**",
            "/v2/api-docs",
            "/doc.html",
            "/swagger-ui.html",
            "/swagger-resources/**"
    );

    @Override
    public List<String> excludePathPatterns() {
        return EXCLUDE_PATH_PATTERS;
    }
}
