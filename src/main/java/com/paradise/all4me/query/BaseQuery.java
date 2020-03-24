package com.paradise.all4me.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class BaseQuery {
    @ApiModelProperty(value = "页码")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "每页数量")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "查询起始时间戳")
    private Integer startTimestamp;
    @ApiModelProperty(value = "查询结束时间戳")
    private Integer endTimestamp;
}
