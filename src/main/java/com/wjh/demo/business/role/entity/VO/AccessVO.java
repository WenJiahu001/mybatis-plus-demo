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
 * 权限
 * @author wjh
 * @since 2022-07-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "权限展示实体类", description = "权限")
public class AccessVO extends Access implements Serializable{


    @ApiModelProperty(value = "权限名")
    private String name;
    @ApiModelProperty(value = "key")
    private String accessKey;
    @ApiModelProperty(value = "权限路径")
    private String uri;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

}