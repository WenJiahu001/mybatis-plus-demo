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
 * 角色权限 Mapper 接口
 * </p>
 *
 * @author wjh
 * @since 2022-07-29
 */
public interface RoleAccessDao extends BaseMapper<RoleAccess> {


    @Select({"select 1 from role_access limit 1"})
    @Results(id = "RoleAccessVO", value = {
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "update_time", property = "updateTime"),
        @Result(column = "role_id", property = "roleId"),
        @Result(column = "access_id", property = "accessId"),
        @Result(column = "id", property = "id")
    })
    RoleAccessVO resultMap();

    @ResultMap(value = "RoleAccessVO")
    @Select("<script>" +
            " select a.* from role_access a " +
            " where a.deleted=0 " +
            "<if test='createTimeEnd!=null'> and a.create_time <![CDATA[<]]> #{createTimeEnd}</if>" +
            "<if test='createTimeBegin!=null'> and a.create_time <![CDATA[>=]]> #{createTimeBegin}</if>" +
            "<if test='updateTimeEnd!=null'> and a.update_time <![CDATA[<]]> #{updateTimeEnd}</if>" +
            "<if test='updateTimeBegin!=null'> and a.update_time <![CDATA[>=]]> #{updateTimeBegin}</if>" +
            "<if test='roleId!=null'> and a.role_id=#{roleId}</if>" +
            "<if test='accessId!=null'> and a.access_id=#{accessId}</if>" +
            "</script>")
    List<RoleAccessVO> selectListVo(RoleAccessQueryDTO dto);

    @ResultMap(value = "RoleAccessVO")
    @Select(" select a.* from role_access a " +
            " where a.id=#{id} and a.deleted=0 ")
    RoleAccessVO selectDetailById(Integer id);


}