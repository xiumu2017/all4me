package com.paradise.all4me.domain;

import com.paradise.all4me.config.RegexpConfiguration;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * @author Paradise
 */
@ApiModel("管理员登录实体信息")
@Data
public class RegisterBean {

    @Length(max = 20, min = 5, message = "用户名长度在5-20个字符之间")
    @Pattern(regexp = "\\w{5,20}", message = "合法用户名为英文和数字组合")
    @ApiModelProperty(value = "用户名")
    private String username;

    @Email(message = "Email格式不正确")
    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "密码不能为空")
    @Pattern(regexp = "\\w{8,20}", message = "合法密码为英文和数字组合")
    @Size(max = 20, min = 8, message = "密码长度在8-20位之间")
    private String password;

    @NotBlank(message = "手机号码不能为空")
    @ApiModelProperty(value = "手机号")
    @Pattern(regexp = "1(([356789])[0-9]|47)[0-9]{8}", message = "手机号码格式不正确")
    private String telephone;

    @NotBlank(message = "验证码不能为空")
    @Pattern(regexp = "\\d{6}", message = "验证码格式不正确")
    @ApiModelProperty(value = "验证码")
    private String smsCode;

    @Pattern(regexp = RegexpConfiguration.UID, message = "邀请码格式不正确")
    @ApiModelProperty(value = "邀请码")
    private String uid;

    public static void main(String[] args) {
        String regexp = "1(([356789])[0-9]|47)[0-9]{8}";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regexp);

        System.out.println(pattern.matcher("13000001234").matches());
        System.out.println(pattern.matcher("14700001234").matches());
        System.out.println(pattern.matcher("10700001234").matches());
        System.out.println(pattern.matcher("1310700001234").matches());
    }

}
