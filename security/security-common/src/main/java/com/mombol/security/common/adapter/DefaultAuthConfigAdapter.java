package com.mombol.security.common.adapter;

import java.util.Collections;
import java.util.List;

public class DefaultAuthConfigAdapter implements AuthConfigAdapter {
    public DefaultAuthConfigAdapter() {
    }

    @Override
    public List<String> pathPatterns() {
        return Collections.singletonList("/*");
    }

    @Override
    public List<String> excludePathPatterns() {
        return Collections.emptyList();
    }
}
