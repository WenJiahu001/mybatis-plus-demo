package com.wjh.demo.business.test.entity.DTO;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * 账号表
 * @author wjh
 * @since 2022-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "账号表查询实体类", description = "账号表")
public class UserQueryDTO implements Serializable{


    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "email")
    private String email;
    @ApiModelProperty(value = "创建时间")
    private Date createTimeBegin;
    private Date createTimeEnd;
    @ApiModelProperty(value = "修改时间")
    private Date updateTimeBegin;
    private Date updateTimeEnd;

}