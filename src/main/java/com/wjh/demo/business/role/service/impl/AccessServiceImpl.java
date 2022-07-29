package com.wjh.demo.business.role.service.impl;

import com.wjh.demo.business.role.entity.*;
import com.wjh.demo.business.role.entity.VO.*;
import com.wjh.demo.business.role.entity.DTO.*;
import com.wjh.demo.business.role.mapper.AccessDao;
import com.wjh.demo.business.role.service.AccessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.wjh.demo.common.vo.PageResult;
import com.wjh.demo.common.vo.PageWrapper;
import com.wjh.demo.utils.PageUtils;
import java.util.List;
import com.wjh.demo.common.ex.BusinessTargetNotExistsException;
import cn.hutool.core.bean.BeanUtil;


/**
 * 权限 服务实现类
 * @author wjh
 * @since 2022-07-29
 */
@Service
public class AccessServiceImpl extends ServiceImpl<AccessDao, Access> implements AccessService {
    @Override
    public PageResult<AccessVO> listVO(AccessQueryDTO dto,PageWrapper wrapper) {
        PageUtils.startPage(wrapper.getPageIndex(), wrapper.getPageSize(), wrapper.getSortField(), wrapper.getSort());
        List<AccessVO> list = this.listVO(dto);
        PageResult pageResult = PageUtils.genPageResult(list);
        return pageResult;
    }
    @Override
    public List<AccessVO> listVO(AccessQueryDTO dto) {
        List<AccessVO> list = this.getBaseMapper().selectListVo(dto);
        return list;
    }

    @Override
    public AccessVO getDetailById(Integer id){
        AccessVO vo = this.getBaseMapper().selectDetailById(id);
        if (vo == null)
            throw new BusinessTargetNotExistsException();
        return vo;
    }

    @Override
    public boolean add(AccessAddDTO dto){
        Access add = BeanUtil.copyProperties(dto, Access.class);
        return this.save(add);
    }

    @Override
    public boolean edit(AccessEditDTO dto){
        Access edit = BeanUtil.copyProperties(dto, Access.class);
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