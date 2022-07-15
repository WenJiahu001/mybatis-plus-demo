package com.wjh.demo.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author 文家虎
 * @Package com.wjh.demo.common.entity
 * @date 2021/6/16 09:49
 */
@Data
public class Entity {

    @TableId(value = "id")
    private Long id;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "逻辑删除 1表示删除")
    @TableField("deleted")
    @TableLogic
    private Boolean deleted;
}
