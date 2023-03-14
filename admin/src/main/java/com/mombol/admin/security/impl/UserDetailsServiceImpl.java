package com.mombol.admin.security.impl;

import com.mombol.admin.security.entity.AdminUserDetail;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

//@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Set authoritiesSet = new HashSet();
        GrantedAuthority adminRoleAuthority = new SimpleGrantedAuthority("ADMIN_ROLE");
        authoritiesSet.add(adminRoleAuthority);

        return new AdminUserDetail(username, new BCryptPasswordEncoder().encode("123123"));
    }

}
