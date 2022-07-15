package com.wjh.demo.business.system.entity.DTO;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * 
 * @author wjh
 * @since 2022-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "修改实体类", description = "")
public class LogEditDTO implements Serializable{


    private static final long serialVersionUID=1L;

    private Long id;

    @ApiModelProperty(value = "内容")
    private String logContent;
    @ApiModelProperty(value = "日志类型(0:操作日志;1:登录日志;2:定时任务)")
    private Integer logType;
    private String method;
    @ApiModelProperty(value = "操作类型(1:添加;2:修改;3:删除;)")
    private Integer operateType;
    @ApiModelProperty(value = "请求参数")
    private String requestParam;
    private String ip;
    private Integer createBy;
    private String createName;
    private Long costTime;

}