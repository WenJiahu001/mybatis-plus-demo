package com.wjh.demo.business.role.entity.DTO;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * 权限
 * @author wjh
 * @since 2022-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "权限添加实体类", description = "权限")
public class AccessAddDTO implements Serializable{


    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "权限名")
    private String name;
    @ApiModelProperty(value = "key")
    private String accessKey;
    @ApiModelProperty(value = "权限路径")
    private String uri;

}