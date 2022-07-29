package com.wjh.demo.business.test.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import com.wjh.demo.common.entity.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 账号表
 *
 * @author wjh
 * @since 2022-07-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "User实体类", description = "账号表")
public class User extends Entity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "姓名")
    @TableField("name")
    private String name;


    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "年龄")
    @TableField("age")
    private Integer age;

    @ApiModelProperty(value = "email")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "乐观锁字段")
    @TableField("version")
    @Version
    private Integer version;


}