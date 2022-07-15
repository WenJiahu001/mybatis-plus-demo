package com.wjh.demo.business.test.service.impl;

import com.wjh.demo.business.test.entity.*;
import com.wjh.demo.business.test.entity.VO.*;
import com.wjh.demo.business.test.entity.DTO.*;
import com.wjh.demo.business.test.mapper.UserDao;
import com.wjh.demo.business.test.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import com.wjh.demo.common.vo.PageResult;
import com.wjh.demo.common.vo.PageWrapper;
import com.wjh.demo.utils.PageUtils;


/**
 * 账号表 服务实现类
 * @author wjh
 * @since 2022-07-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Override
    public PageResult<UserVO> listVO(UserQueryDTO dto,PageWrapper wrapper) {
        PageUtils.startPage(wrapper.getPageIndex(), wrapper.getPageSize(), wrapper.getSortField(), wrapper.getSort());
        List<UserVO> list = this.listVO(dto);
        PageResult pageResult = PageUtils.genPageResult(list);
        return pageResult;
    }
    @Override
    public List<UserVO> listVO(UserQueryDTO dto) {
        List<UserVO> list = this.getBaseMapper().selectListVo(dto);
        return list;
    }

    @Override
    public UserVO getDetailById(Integer id){
        return this.getBaseMapper().selectDetailById(id);
    }

    @Override
    public boolean add(UserAddDTO dto){
        User add = new User();
        BeanUtils.copyProperties(dto, add);
        return this.save(add);
    }

    @Override
    public boolean edit(UserEditDTO dto){
        User edit = new User();
        BeanUtils.copyProperties(dto, edit);
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