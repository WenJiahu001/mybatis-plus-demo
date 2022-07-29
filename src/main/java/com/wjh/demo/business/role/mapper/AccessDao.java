package com.wjh.demo.business.role.mapper;

import com.wjh.demo.business.role.entity.*;
import com.wjh.demo.business.role.entity.VO.*;
import com.wjh.demo.business.role.entity.DTO.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import java.util.List;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author wjh
 * @since 2022-07-29
 */
public interface AccessDao extends BaseMapper<Access> {


    @Select({"select 1 from access limit 1"})
    @Results(id = "AccessVO", value = {
        @Result(column = "name", property = "name"),
        @Result(column = "access_key", property = "accessKey"),
        @Result(column = "uri", property = "uri"),
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "update_time", property = "updateTime"),
        @Result(column = "id", property = "id")
    })
    AccessVO resultMap();

    @ResultMap(value = "AccessVO")
    @Select("<script>" +
            " select a.* from access a " +
            " where a.deleted=0 " +
            "<if test='name!=null and name!=\"\"'> and a.name like CONCAT('%',#{name},'%')</if>" +
            "<if test='accessKey!=null and accessKey!=\"\"'> and a.access_key=#{accessKey}</if>" +
            "<if test='uri!=null and uri!=\"\"'> and a.uri=#{uri}</if>" +
            "<if test='createTimeEnd!=null'> and a.create_time <![CDATA[<]]> #{createTimeEnd}</if>" +
            "<if test='createTimeBegin!=null'> and a.create_time <![CDATA[>=]]> #{createTimeBegin}</if>" +
            "<if test='updateTimeEnd!=null'> and a.update_time <![CDATA[<]]> #{updateTimeEnd}</if>" +
            "<if test='updateTimeBegin!=null'> and a.update_time <![CDATA[>=]]> #{updateTimeBegin}</if>" +
            "</script>")
    List<AccessVO> selectListVo(AccessQueryDTO dto);

    @ResultMap(value = "AccessVO")
    @Select(" select a.* from access a " +
            " where a.id=#{id} and a.deleted=0 ")
    AccessVO selectDetailById(Integer id);


}