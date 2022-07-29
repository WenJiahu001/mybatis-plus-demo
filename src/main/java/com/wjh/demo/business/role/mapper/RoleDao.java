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
 * demo Mapper 接口
 * </p>
 *
 * @author wjh
 * @since 2022-07-29
 */
public interface RoleDao extends BaseMapper<Role> {


    @Select({"select 1 from role limit 1"})
    @Results(id = "RoleVO", value = {
        @Result(column = "name", property = "name"),
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "update_time", property = "updateTime"),
        @Result(column = "id", property = "id")
    })
    RoleVO resultMap();

    @ResultMap(value = "RoleVO")
    @Select("<script>" +
            " select a.* from role a " +
            " where a.deleted=0 " +
            "<if test='name!=null and name!=\"\"'> and a.name like CONCAT('%',#{name},'%')</if>" +
            "<if test='createTimeEnd!=null'> and a.create_time <![CDATA[<]]> #{createTimeEnd}</if>" +
            "<if test='createTimeBegin!=null'> and a.create_time <![CDATA[>=]]> #{createTimeBegin}</if>" +
            "<if test='updateTimeEnd!=null'> and a.update_time <![CDATA[<]]> #{updateTimeEnd}</if>" +
            "<if test='updateTimeBegin!=null'> and a.update_time <![CDATA[>=]]> #{updateTimeBegin}</if>" +
            "</script>")
    List<RoleVO> selectListVo(RoleQueryDTO dto);

    @ResultMap(value = "RoleVO")
    @Select(" select a.* from role a " +
            " where a.id=#{id} and a.deleted=0 ")
    RoleVO selectDetailById(Integer id);


}