package com.mombol.security.common.adapter;

import java.util.List;

public interface AuthConfigAdapter {

    List<String> pathPatterns();

    List<String> excludePathPatterns();

}
