package com.paradise.all4me.sleep.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Created by Mybatis Generator 2020/03/24
 */
@ApiModel(value = "睡眠记录")
@Data
@Builder
public class SleepRecord {
    /**
     * 自增主键
     */
    @ApiModelProperty(value = "自增主键")
    private Long id;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Integer uid;

    /**
     * 日期
     */
    @ApiModelProperty(value = "日期")
    private String date;

    /**
     * 上床时间
     */
    @ApiModelProperty(value = "上床时间")
    private Integer bedTime;

    /**
     * 入睡时间
     */
    @ApiModelProperty(value = "入睡时间")
    private Integer fallTime;

    /**
     * 醒来时间
     */
    @ApiModelProperty(value = "醒来时间")
    private Integer wakeTime;

    /**
     * 起床时间
     */
    @ApiModelProperty(value = "起床时间")
    private Integer upTime;

    /**
     * 是否做梦
     */
    @ApiModelProperty(value = "是否做梦")
    private Integer haveDream;

    /**
     * 睡眠质量
     */
    @ApiModelProperty(value = "睡眠质量")
    private Integer sleepQuality;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
}