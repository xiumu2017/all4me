package com.paradise.all4me.controller;

import com.paradise.all4me.domain.LoginBean;
import com.paradise.all4me.domain.RegisterBean;
import com.paradise.all4me.domain.User;
import com.paradise.all4me.restful.R;
import com.paradise.all4me.restful.Rx;
import com.paradise.all4me.restful.reponse.LoginRes;
import com.paradise.all4me.service.UserService;
import com.paradise.all4me.utils.CommonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Paradise
 */
@Api(tags = "分站用户：我的")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserLoginController {
    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Value("${config.testCode}")
    private final String testCode = "777777";

    @PostMapping("/register")
    @ApiOperation("用户注册")
    public R<User> registry(@Valid @RequestBody RegisterBean register) {
        // 验证码校验
        Assert.isTrue(testCode.equals(register.getSmsCode()), "短信验证码错误");
        if (userService.register(register) == 1) {
            return Rx.success();
        }
        return Rx.fail();
    }


    @ApiOperation(value = "分站用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public R<LoginRes> login(@Valid @RequestBody LoginBean loginBean,
                             @ApiIgnore HttpServletRequest request) {
        // 用户名，邮箱，手机号码存在性校验发生在登录接口之前，配合验证码逻辑
        String token = userService.login(loginBean);
        if (StringUtils.isEmpty(token)) {
            return Rx.fail("登录异常");
        }
        LoginRes loginRes = new LoginRes(token, tokenHead);
        return Rx.success(loginRes);
    }

    @ApiOperation("拉取用户信息")
    @GetMapping(value = "/info")
    public R<Map<String, Object>> getUserInfo(@ApiIgnore Principal principal) {
        User user = CommonUtils.getUser(principal);
        if (user == null) {
            return Rx.fail("用户不存在或已被删除");
        }
        Map<String, Object> resultMap = new HashMap<>(6);
        resultMap.put("baseInfo", user);
        return Rx.success(resultMap);
    }

}

