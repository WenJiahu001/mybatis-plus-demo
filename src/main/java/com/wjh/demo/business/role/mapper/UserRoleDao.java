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
 * 用户角色 Mapper 接口
 * </p>
 *
 * @author wjh
 * @since 2022-07-29
 */
public interface UserRoleDao extends BaseMapper<UserRole> {


    @Select({"select 1 from user_role limit 1"})
    @Results(id = "UserRoleVO", value = {
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "update_time", property = "updateTime"),
        @Result(column = "user_id", property = "userId"),
        @Result(column = "role_id", property = "roleId"),
        @Result(column = "id", property = "id")
    })
    UserRoleVO resultMap();

    @ResultMap(value = "UserRoleVO")
    @Select("<script>" +
            " select a.* from user_role a " +
            " where a.deleted=0 " +
            "<if test='createTimeEnd!=null'> and a.create_time <![CDATA[<]]> #{createTimeEnd}</if>" +
            "<if test='createTimeBegin!=null'> and a.create_time <![CDATA[>=]]> #{createTimeBegin}</if>" +
            "<if test='updateTimeEnd!=null'> and a.update_time <![CDATA[<]]> #{updateTimeEnd}</if>" +
            "<if test='updateTimeBegin!=null'> and a.update_time <![CDATA[>=]]> #{updateTimeBegin}</if>" +
            "<if test='userId!=null'> and a.user_id=#{userId}</if>" +
            "<if test='roleId!=null'> and a.role_id=#{roleId}</if>" +
            "</script>")
    List<UserRoleVO> selectListVo(UserRoleQueryDTO dto);

    @ResultMap(value = "UserRoleVO")
    @Select(" select a.* from user_role a " +
            " where a.id=#{id} and a.deleted=0 ")
    UserRoleVO selectDetailById(Integer id);


}