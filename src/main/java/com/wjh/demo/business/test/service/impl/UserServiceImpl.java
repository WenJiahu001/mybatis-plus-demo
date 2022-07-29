package com.wjh.demo.business.test.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjh.demo.business.test.entity.DTO.UserAddDTO;
import com.wjh.demo.business.test.entity.DTO.UserEditDTO;
import com.wjh.demo.business.test.entity.DTO.UserQueryDTO;
import com.wjh.demo.business.test.entity.User;
import com.wjh.demo.business.test.entity.VO.UserVO;
import com.wjh.demo.business.test.mapper.UserDao;
import com.wjh.demo.business.test.service.UserService;
import com.wjh.demo.common.ex.BusinessTargetNotExistsException;
import com.wjh.demo.common.vo.PageResult;
import com.wjh.demo.common.vo.PageWrapper;
import com.wjh.demo.security.SecurityUtils;
import com.wjh.demo.utils.PageUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * 账号表 服务实现类
 *
 * @author wjh
 * @since 2022-07-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Override
    public PageResult<UserVO> listVO(UserQueryDTO dto, PageWrapper wrapper) {
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
    public UserVO getDetailById(Integer id) {
        UserVO vo = this.getBaseMapper().selectDetailById(id);
        if (vo == null)
            throw new BusinessTargetNotExistsException();
        return vo;
    }

    @Override
    public boolean add(UserAddDTO dto) {
        User add = BeanUtil.copyProperties(dto, User.class);
        return this.save(add);
    }

    @Override
    public boolean edit(UserEditDTO dto) {
        User edit = BeanUtil.copyProperties(dto, User.class);
        return this.updateById(edit);
    }

    @Override
    public boolean remove(Long id) {
        return this.removeById(id);
    }

    @Override
    public boolean remove(List<Long> ids) {
        return this.removeByIds(ids);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> getUserWithAuthorities() {
        return SecurityUtils.getCurrentUsername().flatMap(a -> this.findOneWithAuthoritiesByUsername(a));
    }

    @Override
    public Optional<User> findOneWithAuthoritiesByUsername(String userName) {
        QueryWrapper<User> w = new QueryWrapper<>();
        w.lambda().eq(User::getName, userName);
        User one = this.getOne(w);
        return Optional.ofNullable(one);
    }
}