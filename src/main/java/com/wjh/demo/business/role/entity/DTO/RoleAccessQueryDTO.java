package com.wjh.demo.business.role.entity.DTO;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * 角色权限
 * @author wjh
 * @since 2022-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "角色权限查询实体类", description = "角色权限")
public class RoleAccessQueryDTO implements Serializable{


    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "创建时间")
    private Date createTimeBegin;
    private Date createTimeEnd;
    @ApiModelProperty(value = "修改时间")
    private Date updateTimeBegin;
    private Date updateTimeEnd;
    @ApiModelProperty(value = "角色id")
    private Long roleId;
    @ApiModelProperty(value = "权限id")
    private Long accessId;

}