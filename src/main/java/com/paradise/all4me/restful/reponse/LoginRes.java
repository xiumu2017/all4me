package com.paradise.all4me.restful.reponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@ApiModel
@AllArgsConstructor
public class LoginRes {

    @ApiModelProperty("token")
    private String token;
    @ApiModelProperty("tokenHead")
    private String tokenHead;
}
