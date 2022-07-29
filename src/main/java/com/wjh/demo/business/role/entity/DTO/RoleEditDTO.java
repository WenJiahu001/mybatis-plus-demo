package com.wjh.demo.business.role.entity.DTO;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * demo
 * @author wjh
 * @since 2022-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "demo修改实体类", description = "demo")
public class RoleEditDTO implements Serializable{


    private static final long serialVersionUID=1L;

    private Long id;

    @ApiModelProperty(value = "角色名")
    private String name;

}