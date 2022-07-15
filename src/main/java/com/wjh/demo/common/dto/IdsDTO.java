package com.wjh.demo.common.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author 文家虎
 * @Package com.wjh.demo.common.dto
 * @date 2021/4/29 17:11
 */
@Data
public class IdsDTO {
    @NotEmpty
    private List<Long> ids;
}
