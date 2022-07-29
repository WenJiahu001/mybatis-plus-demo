package com.wjh.demo.business.role.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.wjh.demo.common.entity.Entity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 权限
 * @author wjh
 * @since 2022-07-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Access实体类", description = "权限")
public class Access extends Entity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "权限名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "key")
    @TableField("access_key")
    private String accessKey;

    @ApiModelProperty(value = "权限路径")
    @TableField("uri")
    private String uri;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}