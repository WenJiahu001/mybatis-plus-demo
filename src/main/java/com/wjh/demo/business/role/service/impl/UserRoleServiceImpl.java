package com.wjh.demo.business.role.service.impl;

import com.wjh.demo.business.role.entity.*;
import com.wjh.demo.business.role.entity.VO.*;
import com.wjh.demo.business.role.entity.DTO.*;
import com.wjh.demo.business.role.mapper.UserRoleDao;
import com.wjh.demo.business.role.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.wjh.demo.common.vo.PageResult;
import com.wjh.demo.common.vo.PageWrapper;
import com.wjh.demo.utils.PageUtils;
import java.util.List;
import com.wjh.demo.common.ex.BusinessTargetNotExistsException;
import cn.hutool.core.bean.BeanUtil;


/**
 * 用户角色 服务实现类
 * @author wjh
 * @since 2022-07-29
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole> implements UserRoleService {
    @Override
    public PageResult<UserRoleVO> listVO(UserRoleQueryDTO dto,PageWrapper wrapper) {
        PageUtils.startPage(wrapper.getPageIndex(), wrapper.getPageSize(), wrapper.getSortField(), wrapper.getSort());
        List<UserRoleVO> list = this.listVO(dto);
        PageResult pageResult = PageUtils.genPageResult(list);
        return pageResult;
    }
    @Override
    public List<UserRoleVO> listVO(UserRoleQueryDTO dto) {
        List<UserRoleVO> list = this.getBaseMapper().selectListVo(dto);
        return list;
    }

    @Override
    public UserRoleVO getDetailById(Integer id){
        UserRoleVO vo = this.getBaseMapper().selectDetailById(id);
        if (vo == null)
            throw new BusinessTargetNotExistsException();
        return vo;
    }

    @Override
    public boolean add(UserRoleAddDTO dto){
        UserRole add = BeanUtil.copyProperties(dto, UserRole.class);
        return this.save(add);
    }

    @Override
    public boolean edit(UserRoleEditDTO dto){
        UserRole edit = BeanUtil.copyProperties(dto, UserRole.class);
        return this.updateById(edit);
    }

    @Override
    public boolean remove(Long id){
        return this.removeById(id);
    }

    @Override
    public boolean remove(List<Long> ids){
        return this.removeByIds(ids);
    }
}