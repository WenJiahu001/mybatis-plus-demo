package com.wjh.demo.business.test.mapper;

import com.wjh.demo.business.test.entity.*;
import com.wjh.demo.business.test.entity.VO.*;
import com.wjh.demo.business.test.entity.DTO.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import java.util.List;

/**
 * <p>
 * 账号表 Mapper 接口
 * </p>
 *
 * @author wjh
 * @since 2022-07-15
 */
public interface UserDao extends BaseMapper<User> {


    @Select({"select 1 from user limit 1"})
    @Results(id = "UserVO", value = {
        @Result(column = "name", property = "name"),
        @Result(column = "age", property = "age"),
        @Result(column = "email", property = "email"),
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "update_time", property = "updateTime"),
        @Result(column = "version", property = "version"),
        @Result(column = "id", property = "id")
    })
    UserVO resultMap();

    @ResultMap(value = "UserVO")
    @Select("<script>" +
            " select a.* from user a " +
            " where a.deleted=0 " +
            "<if test='name!=null and name!=\"\"'> and a.name like CONCAT('%',#{name},'%')</if>" +
            "<if test='age!=null'> and a.age=#{age}</if>" +
            "<if test='email!=null and email!=\"\"'> and a.email=#{email}</if>" +
            "<if test='createTimeEnd!=null'> and a.create_time <![CDATA[<]]> #{createTimeEnd}</if>" +
            "<if test='createTimeBegin!=null'> and a.create_time <![CDATA[>=]]> #{createTimeBegin}</if>" +
            "<if test='updateTimeEnd!=null'> and a.update_time <![CDATA[<]]> #{updateTimeEnd}</if>" +
            "<if test='updateTimeBegin!=null'> and a.update_time <![CDATA[>=]]> #{updateTimeBegin}</if>" +
            "</script>")
    List<UserVO> selectListVo(UserQueryDTO dto);

    @ResultMap(value = "UserVO")
    @Select( " select a.* from user a " +
            " where a.id=#{id} and a.deleted=0 ")
    UserVO selectDetailById(Integer id);


}