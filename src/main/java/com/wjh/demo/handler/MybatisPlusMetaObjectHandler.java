package com.wjh.demo.handler;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * ClassName:MybatisPlusMetaObjectHandler
 * Package:
 *
 * @Date:2021/2/22 17:29
 * @Author:WenJiahu
 */
@Component
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", DateTime.now(), metaObject);
        this.setFieldValByName("updateTime", DateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", DateTime.now(), metaObject);
    }
}
