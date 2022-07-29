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
 * demo
 * @author wjh
 * @since 2022-07-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "demo展示实体类", description = "demo")
public class RoleVO extends Role implements Serializable{


    @ApiModelProperty(value = "角色名")
    private String name;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

}