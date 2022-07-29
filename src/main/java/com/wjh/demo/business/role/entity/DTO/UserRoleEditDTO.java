package com.wjh.demo.business.role.entity.DTO;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * 用户角色
 * @author wjh
 * @since 2022-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "用户角色修改实体类", description = "用户角色")
public class UserRoleEditDTO implements Serializable{


    private static final long serialVersionUID=1L;

    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userId;
    @ApiModelProperty(value = "角色id")
    private Long roleId;

}