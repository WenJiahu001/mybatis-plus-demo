package com.wjh.demo.business.role.service.impl;

import com.wjh.demo.business.role.entity.*;
import com.wjh.demo.business.role.entity.VO.*;
import com.wjh.demo.business.role.entity.DTO.*;
import com.wjh.demo.business.role.mapper.RoleAccessDao;
import com.wjh.demo.business.role.service.RoleAccessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.wjh.demo.common.vo.PageResult;
import com.wjh.demo.common.vo.PageWrapper;
import com.wjh.demo.utils.PageUtils;
import java.util.List;
import com.wjh.demo.common.ex.BusinessTargetNotExistsException;
import cn.hutool.core.bean.BeanUtil;


/**
 * 角色权限 服务实现类
 * @author wjh
 * @since 2022-07-29
 */
@Service
public class RoleAccessServiceImpl extends ServiceImpl<RoleAccessDao, RoleAccess> implements RoleAccessService {
    @Override
    public PageResult<RoleAccessVO> listVO(RoleAccessQueryDTO dto,PageWrapper wrapper) {
        PageUtils.startPage(wrapper.getPageIndex(), wrapper.getPageSize(), wrapper.getSortField(), wrapper.getSort());
        List<RoleAccessVO> list = this.listVO(dto);
        PageResult pageResult = PageUtils.genPageResult(list);
        return pageResult;
    }
    @Override
    public List<RoleAccessVO> listVO(RoleAccessQueryDTO dto) {
        List<RoleAccessVO> list = this.getBaseMapper().selectListVo(dto);
        return list;
    }

    @Override
    public RoleAccessVO getDetailById(Integer id){
        RoleAccessVO vo = this.getBaseMapper().selectDetailById(id);
        if (vo == null)
            throw new BusinessTargetNotExistsException();
        return vo;
    }

    @Override
    public boolean add(RoleAccessAddDTO dto){
        RoleAccess add = BeanUtil.copyProperties(dto, RoleAccess.class);
        return this.save(add);
    }

    @Override
    public boolean edit(RoleAccessEditDTO dto){
        RoleAccess edit = BeanUtil.copyProperties(dto, RoleAccess.class);
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