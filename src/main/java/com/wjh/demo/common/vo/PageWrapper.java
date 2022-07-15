package com.wjh.demo.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;

/**
 * 分页查询，参数接收类
 *
 */
@Data
public class PageWrapper {

    /**
     * 当前页数
     */
    private Integer pageIndex;

    /**
     * 每页记录数
     */
    private Integer pageSize;

    /**
     * 排序字段
     */
    private String sortField;

    /**
     * asc or desc
     */
    private String sort;
}
