package com.wjh.demo.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel
@Data
public class PageResult<T> {

    @ApiModelProperty(value = "页索引，默认值1")
    private int pageIndex;
    @ApiModelProperty(value = "页大小，默认值20")
    private int pageSize;
    @ApiModelProperty(value = "数据行总数")
    private int total;
    @ApiModelProperty(value = "数据行列表")
    private List<T> items;

    public PageResult() {
    }

    public PageResult(int pageIndex, int pageSize, int total, List<T> items) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.total = total;
        this.items = items;
    }
}

