package com.paradise.all4me.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 * Created by Mybatis Generator 2020/03/06
 */
@ApiModel(value = "com.paradise.all4me.domain.User")
@Data
public class User {
    public static final String COL_TELEPHONE = "telephone";
    public static final String COL_EMAIL = "email";
    public static final String COL_PASSWORD = "password";
    public static final String COL_USERNAME = "username";
    public static final String COL_STATUS = "status";
    public static final String COL_IS_DEL = "is_del";
    public static final String COL_CREATE_TIME = "create_time";
    public static final String COL_UPDATE_TIME = "update_time";
    public static final String COL_REMARK = "remark";
    public static final String COL_CREATE_BY = "create_by";
    /**
     * 自增主键
     */
    @ApiModelProperty(value = "自增主键")
    private Integer id;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String telephone;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Boolean status;

    /**
     * =1 删除
     */
    @ApiModelProperty(value = "=1 删除")
    private Boolean isDel;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private Integer createBy;

    public User() {
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.paradise.all4me.domain.User;
    }
}