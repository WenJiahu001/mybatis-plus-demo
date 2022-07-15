package com.wjh.demo.business.system.entity;

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
 * 
 * @author wjh
 * @since 2022-07-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Log实体类", description = "")
public class Log extends Entity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "内容")
    @TableField("log_content")
    private String logContent;

    @ApiModelProperty(value = "日志类型(0:操作日志;1:登录日志;2:定时任务)")
    @TableField("log_type")
    private Integer logType;

    @TableField("method")
    private String method;

    @ApiModelProperty(value = "操作类型(1:添加;2:修改;3:删除;)")
    @TableField("operate_type")
    private Integer operateType;

    @ApiModelProperty(value = "请求参数")
    @TableField("request_param")
    private String requestParam;

    @TableField("ip")
    private String ip;

    @TableField("create_by")
    private Integer createBy;

    @TableField("create_name")
    private String createName;

    @TableField("cost_time")
    private Long costTime;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}