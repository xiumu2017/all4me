package com.paradise.all4me.security;

import com.paradise.all4me.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity需要的用户详情
 *
 * @author macro
 * @date 2018/4/26
 */
public class AdminUserDetails implements UserDetails {
    private final User user;
    private final List<Object> permissionList;

    public AdminUserDetails(User umsAdmin, List<Object> permissionList) {
        this.user = umsAdmin;
        this.permissionList = permissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return new ArrayList<>();
//        return permissionList.stream()
//                .filter(permission -> permission.getValue() != null)
//                .map(permission -> new SimpleGrantedAuthority(permission.getValue()))
//                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    private Integer getUid(){
        return user.getId();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getStatus();
    }
}
