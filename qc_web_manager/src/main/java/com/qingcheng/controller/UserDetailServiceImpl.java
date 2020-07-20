package com.qingcheng.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.pojo.system.Admin;
import com.qingcheng.service.system.AdminService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Summerday
 */
public class UserDetailServiceImpl implements UserDetailsService {

    @Reference
    private AdminService adminService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("UserDetailServiceImpl.loadUserByUsername");

        Map<String,Object> map = new HashedMap();
        map.put("loginName",username);
        map.put("status","1");

        List<Admin> list = adminService.findList(map);
        if(list.size() == 0){
            return null;
        }

        //实际项目中 需要从数据库中读取用户拥有的角色列表
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new User(username,list.get(0).getPassword(),grantedAuthorities);
    }
}
