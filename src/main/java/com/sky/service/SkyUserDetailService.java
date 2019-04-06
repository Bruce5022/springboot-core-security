package com.sky.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.entity.Permission;
import com.sky.entity.User;
import com.sky.mapper.UserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class SkyUserDetailService implements UserDetailsService {

    private Logger logger = Logger.getLogger(SkyUserDetailService.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户
        User user = userMapper.findByUsername(username);
        if (ObjectUtils.isEmpty(user)) {
            return user;
        }
        // 查询用户权限
        List<Permission> permissions = userMapper.findPermissionByUsername(username);
        List<GrantedAuthority> authoritys = new ArrayList<GrantedAuthority>();
        for (Permission permission : permissions) {
            GrantedAuthority authority = new SimpleGrantedAuthority(permission.getPermTag());
            authoritys.add(authority);
        }
        user.setAuthorities(authoritys);
        try {
            logger.info("用户:" + new ObjectMapper().writeValueAsString(user));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return user;
    }
}
