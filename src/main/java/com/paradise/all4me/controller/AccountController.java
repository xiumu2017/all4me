package com.paradise.all4me.controller;

import com.paradise.all4me.restful.R;
import com.paradise.all4me.restful.Rx;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "账户安全")
@RestController
@RequestMapping("/account")
public class AccountController {

    @ApiOperation("发送验证码")
    @PostMapping("/sms")
    public R<String> sendSmsCode(@RequestBody String mobile) {
        return Rx.success(mobile.substring(6));
    }
}
