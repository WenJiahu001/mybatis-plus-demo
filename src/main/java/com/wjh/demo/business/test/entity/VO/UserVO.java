package com.wjh.demo.business.test.entity.VO;


import com.wjh.demo.business.test.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "账号表展示实体类", description = "账号表")
public class UserVO extends User implements Serializable{


    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "email")
    private String email;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

}