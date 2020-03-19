package com.paradise.all4me.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author Paradise
 */
@ApiModel("管理员登录实体信息")
@Data
public class LoginBean {

    @ApiModelProperty(value = "用户名")
    private String username;

    @Email(message = "Email格式不正确")
    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "手机号")
    @Pattern(regexp = "1(([356789])[0-9]|47)[0-9]{8}", message = "手机号码格式不正确")
    private String telephone;

}
