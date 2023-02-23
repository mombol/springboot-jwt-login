package com.mombol.security.common.permission;

import org.springframework.stereotype.Component;

@Component("pms")
public class PermissionService {
    public boolean hasPermission(String permission) {
        return true;
    }
}
