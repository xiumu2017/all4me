package com.paradise.all4me.service;

import com.paradise.all4me.domain.LoginBean;
import com.paradise.all4me.domain.RegisterBean;
import com.paradise.all4me.domain.User;
import com.paradise.all4me.mapper.UserMapper;
import com.paradise.all4me.security.AdminUserDetails;
import com.paradise.all4me.security.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author Paradise
 */
@Service
@Slf4j
public class UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private JwtTokenUtil jwtTokenUtil;

    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public int insert(User record) {
        return userMapper.insert(record);
    }

    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    // todo 待实现
    public User selectByUsername(String username) {
        return new User();
    }

    /**
     * 注册
     *
     * @param register 注册信息
     * @return result
     */
    public int register(RegisterBean register) {
        User user = new User();
        user.setEmail(register.getTelephone());
        user.setUsername(register.getUsername());
        user.setTelephone(register.getTelephone());
        user.setStatus(true);
        user.setPassword(passwordEncoder.encode(register.getPassword()));
        return userMapper.insert(user);
    }

    /**
     * 用户登录
     *
     * @param loginBean 登录信息
     * @return result
     */
    public String login(LoginBean loginBean) {
        // 判断登录方式 手机号，邮箱，用户名
        User user = null;
        if (!StringUtils.isEmpty(loginBean.getTelephone())) {
            user = userMapper.selectOneByTelephone(loginBean.getTelephone());
        } else if (!StringUtils.isEmpty(loginBean.getEmail())) {
            user = userMapper.selectOneByEmail(loginBean.getEmail());
        }
        if (user == null) {
            return null;
        }
        try {
            if (!passwordEncoder.matches(loginBean.getPassword(), user.getPassword())) {
                throw new BadCredentialsException("用户名或者密码错误");
            }
            AdminUserDetails userDetails = new AdminUserDetails(user, new ArrayList<>());
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userDetails,
                            null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // todo record login log
            return jwtTokenUtil.generateToken(user.getId());
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
            return null;
        }

    }
}
