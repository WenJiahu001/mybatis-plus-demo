package com.wjh.demo.business.role.service;

import com.wjh.demo.business.role.entity.*;
import com.wjh.demo.business.role.entity.VO.*;
import com.wjh.demo.business.role.entity.DTO.*;
import com.wjh.demo.common.dto.IdDTO;
import com.wjh.demo.common.dto.IdsDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wjh.demo.common.vo.PageResult;
import com.wjh.demo.common.vo.PageWrapper;
import java.util.List;

import com.wjh.demo.common.vo.PageResult;
import com.wjh.demo.common.vo.PageWrapper;

/**
 * 用户角色 服务类
 * @author wjh
 * @since 2022-07-29
 */
public interface UserRoleService extends IService<UserRole> {

    PageResult<UserRoleVO> listVO(UserRoleQueryDTO dto,PageWrapper wrapper);

    List<UserRoleVO> listVO(UserRoleQueryDTO dto);

    UserRoleVO getDetailById(Integer id);

    boolean add(UserRoleAddDTO dto);

    boolean edit(UserRoleEditDTO dto);

    boolean remove(Long id);

    boolean remove(List<Long> ids);
}