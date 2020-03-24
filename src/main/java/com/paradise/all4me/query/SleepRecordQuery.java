package com.paradise.all4me.query;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Api
@Data
@EqualsAndHashCode(callSuper = false)
public class SleepRecordQuery extends BaseQuery {
    @ApiModelProperty(value = "用户id")
    private Integer uid;
    @ApiModelProperty(value = "日期")
    private String date;
}

