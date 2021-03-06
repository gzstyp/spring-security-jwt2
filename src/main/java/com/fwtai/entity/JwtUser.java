package com.fwtai.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * 该类封装登录用户相关信息，例如用户名，密码，权限集合等，需要实现UserDetails 接口
*/
public class JwtUser implements UserDetails{

    private Integer id;

    private String username;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public JwtUser(){
    }

    // 写一个能直接使用user创建jwtUser的构造器
    public JwtUser(final User user){
        id = user.getId();
        username = user.getUsername();
        password = user.getPassword();
        authorities = Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }

    public Collection<? extends GrantedAuthority> getAuthorities(){
        return authorities;
    }

    public String getPassword(){
        return password;
    }

    public String getUsername(){
        return username;
    }

    public boolean isAccountNonExpired(){
        return true;
    }

    public boolean isAccountNonLocked(){
        return true;
    }

    public boolean isCredentialsNonExpired(){
        return true;
    }

    public boolean isEnabled(){
        return true;
    }

    @Override
    public String toString(){
        return "JwtUser{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", authorities=" + authorities + '}';
    }
}