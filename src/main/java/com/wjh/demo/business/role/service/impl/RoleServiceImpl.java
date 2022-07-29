package com.wjh.demo.business.role.service.impl;

import com.wjh.demo.business.role.entity.*;
import com.wjh.demo.business.role.entity.VO.*;
import com.wjh.demo.business.role.entity.DTO.*;
import com.wjh.demo.business.role.mapper.RoleDao;
import com.wjh.demo.business.role.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.wjh.demo.common.vo.PageResult;
import com.wjh.demo.common.vo.PageWrapper;
import com.wjh.demo.utils.PageUtils;
import java.util.List;
import com.wjh.demo.common.ex.BusinessTargetNotExistsException;
import cn.hutool.core.bean.BeanUtil;


/**
 * demo 服务实现类
 * @author wjh
 * @since 2022-07-29
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {
    @Override
    public PageResult<RoleVO> listVO(RoleQueryDTO dto,PageWrapper wrapper) {
        PageUtils.startPage(wrapper.getPageIndex(), wrapper.getPageSize(), wrapper.getSortField(), wrapper.getSort());
        List<RoleVO> list = this.listVO(dto);
        PageResult pageResult = PageUtils.genPageResult(list);
        return pageResult;
    }
    @Override
    public List<RoleVO> listVO(RoleQueryDTO dto) {
        List<RoleVO> list = this.getBaseMapper().selectListVo(dto);
        return list;
    }

    @Override
    public RoleVO getDetailById(Integer id){
        RoleVO vo = this.getBaseMapper().selectDetailById(id);
        if (vo == null)
            throw new BusinessTargetNotExistsException();
        return vo;
    }

    @Override
    public boolean add(RoleAddDTO dto){
        Role add = BeanUtil.copyProperties(dto, Role.class);
        return this.save(add);
    }

    @Override
    public boolean edit(RoleEditDTO dto){
        Role edit = BeanUtil.copyProperties(dto, Role.class);
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