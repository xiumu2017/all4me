package com.paradise.all4me.controller;

import com.paradise.all4me.domain.RegisterBean;
import com.paradise.all4me.restful.R;
import com.paradise.all4me.restful.Rx;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Api(value = "账户安全")
@RestController
@RequestMapping("/account")
public class AccountController {

    @ApiOperation("发送验证码")
    @PostMapping("/sms")
    public R<String> sendSmsCode(@RequestBody RegisterBean registerBean) {
        String mobile = registerBean.getMobile();
        Assert.notNull(mobile, "手机号码不能为空");
        String regexp = "1(([356789])[0-9]|47)[0-9]{8}";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(mobile);
        Assert.isTrue(matcher.matches(), "手机号码格式不正确");
        return Rx.success(mobile.substring(6));
    }
}
