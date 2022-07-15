package com.wjh.demo.common.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author 文家虎
 * @Package com.wjh.demo.common.dto
 * @date 2021/4/29 17:10
 */
@Data
public class IdDTO {
    @NotNull
    private Long id;
}
