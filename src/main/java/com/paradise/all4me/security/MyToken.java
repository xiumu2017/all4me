package com.paradise.all4me.security;

import com.paradise.all4me.domain.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 〈一句话功能简述〉<br>
 * 〈mytoken〉
 *
 * @author Administrator
 * @date 2019/12/27/027
 * @since 1.0.0
 */
public class MyToken extends UsernamePasswordAuthenticationToken {


    private Integer userId;

    private User user;

    public MyToken(Object principal, Object credentials, User user) {
        super(principal, credentials);
        setUserId(user.getId());
        setUser(user);
    }

    public MyToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, User user) {
        super(principal, credentials, authorities);
        setUserId(user.getId());
        setUser(user);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
