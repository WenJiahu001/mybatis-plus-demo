package com.wjh.demo.business.system.mapper;

import com.wjh.demo.business.system.entity.*;
import com.wjh.demo.business.system.entity.VO.*;
import com.wjh.demo.business.system.entity.DTO.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjh.demo.business.test.entity.VO.UserVO;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wjh
 * @since 2022-07-15
 */
public interface LogDao extends BaseMapper<Log> {


    @Select({"select 1 from log limit 1"})
    @Results(id = "LogVO", value = {
        @Result(column = "log_content", property = "logContent"),
        @Result(column = "log_type", property = "logType"),
        @Result(column = "method", property = "method"),
        @Result(column = "operate_type", property = "operateType"),
        @Result(column = "request_param", property = "requestParam"),
        @Result(column = "ip", property = "ip"),
        @Result(column = "create_by", property = "createBy"),
        @Result(column = "create_name", property = "createName"),
        @Result(column = "cost_time", property = "costTime"),
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "update_time", property = "updateTime"),
        @Result(column = "id", property = "id")
    })
    LogVO resultMap();

    @ResultMap(value = "LogVO")
    @Select("<script>" +
            " select a.* from log a " +
            " where a.deleted=0 " +
            "<if test='logContent!=null and logContent!=\"\"'> and a.log_content=#{logContent}</if>" +
            "<if test='logType!=null'> and a.log_type=#{logType}</if>" +
            "<if test='method!=null and method!=\"\"'> and a.method=#{method}</if>" +
            "<if test='operateType!=null and operateType!=\"\"'> and a.operate_type=#{operateType}</if>" +
            "<if test='requestParam!=null and requestParam!=\"\"'> and a.request_param=#{requestParam}</if>" +
            "<if test='ip!=null and ip!=\"\"'> and a.ip=#{ip}</if>" +
            "<if test='createBy!=null'> and a.create_by=#{createBy}</if>" +
            "<if test='createName!=null and createName!=\"\"'> and a.create_name like CONCAT('%',#{createName},'%')</if>" +
            "<if test='costTime!=null'> and a.cost_time=#{costTime}</if>" +
            "<if test='createTimeEnd!=null'> and a.create_time <![CDATA[<]]> #{createTimeEnd}</if>" +
            "<if test='createTimeBegin!=null'> and a.create_time <![CDATA[>=]]> #{createTimeBegin}</if>" +
            "<if test='updateTimeEnd!=null'> and a.update_time <![CDATA[<]]> #{updateTimeEnd}</if>" +
            "<if test='updateTimeBegin!=null'> and a.update_time <![CDATA[>=]]> #{updateTimeBegin}</if>" +
            "</script>")
    List<LogVO> selectListVo(LogQueryDTO dto);

    @ResultMap(value = "LogVO")
    @Select( " select a.* from log a " +
            " where a.id=#{id} and a.deleted=0 ")
    LogVO selectDetailById(Integer id);


}