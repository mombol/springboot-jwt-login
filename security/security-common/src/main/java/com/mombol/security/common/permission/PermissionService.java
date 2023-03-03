package com.mombol.security.common.permission;

import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import java.util.Set;

public class PermissionService {

    private Set<String> permissions;

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    public boolean hasPermission(String permission) {
        return getPermissions()
                .stream()
                .filter(StringUtils::hasText)
                .anyMatch(x -> PatternMatchUtils.simpleMatch(permission, x))
                ;
    }

}
