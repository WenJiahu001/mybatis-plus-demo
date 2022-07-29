package com.wjh.demo.business.role.entity.VO;


import com.wjh.demo.business.role.entity.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户角色展示实体类", description = "用户角色")
public class UserRoleVO extends UserRole implements Serializable{


    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
    @ApiModelProperty(value = "用户id")
    private Long userId;
    @ApiModelProperty(value = "角色id")
    private Long roleId;

}