package com.wjh.demo.business.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.wjh.demo.business.system.entity.*;
import com.wjh.demo.business.system.entity.VO.*;
import com.wjh.demo.business.system.entity.DTO.*;
import com.wjh.demo.business.system.mapper.LogDao;
import com.wjh.demo.business.system.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjh.demo.business.test.entity.VO.UserVO;
import com.wjh.demo.common.ex.BusinessTargetNotExistsException;
import org.springframework.stereotype.Service;
import com.wjh.demo.common.vo.PageResult;
import com.wjh.demo.common.vo.PageWrapper;
import com.wjh.demo.utils.PageUtils;

import java.util.List;


/**
 *  服务实现类
 * @author wjh
 * @since 2022-07-15
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogDao, Log> implements LogService {
    @Override
    public PageResult<LogVO> listVO(LogQueryDTO dto,PageWrapper wrapper) {
        PageUtils.startPage(wrapper.getPageIndex(), wrapper.getPageSize(), wrapper.getSortField(), wrapper.getSort());
        List<LogVO> list = this.listVO(dto);
        PageResult pageResult = PageUtils.genPageResult(list);
        return pageResult;
    }
    @Override
    public List<LogVO> listVO(LogQueryDTO dto) {
        List<LogVO> list = this.getBaseMapper().selectListVo(dto);
        return list;
    }

    @Override
    public LogVO getDetailById(Integer id){
        LogVO vo = this.getBaseMapper().selectDetailById(id);
        if (vo == null)
            throw new BusinessTargetNotExistsException();
        return vo;
    }

    @Override
    public boolean add(LogAddDTO dto){
        Log add = BeanUtil.copyProperties(dto, Log.class);
        return this.save(add);
    }

    @Override
    public boolean edit(LogEditDTO dto){
        Log edit = BeanUtil.copyProperties(dto, Log.class);
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