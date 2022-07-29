package com.wjh.demo.business.test.service;

import com.wjh.demo.business.test.entity.*;
import com.wjh.demo.business.test.entity.VO.*;
import com.wjh.demo.business.test.entity.DTO.*;
import com.wjh.demo.common.dto.IdDTO;
import com.wjh.demo.common.dto.IdsDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wjh.demo.common.vo.PageResult;
import com.wjh.demo.common.vo.PageWrapper;
import java.util.List;
import java.util.Optional;

import com.wjh.demo.common.vo.PageResult;
import com.wjh.demo.common.vo.PageWrapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * 账号表 服务类
 * @author wjh
 * @since 2022-07-15
 */
public interface UserService extends IService<User> {

    PageResult<UserVO> listVO(UserQueryDTO dto,PageWrapper wrapper);

    List<UserVO> listVO(UserQueryDTO dto);

    UserVO getDetailById(Integer id);

    boolean add(UserAddDTO dto);

    boolean edit(UserEditDTO dto);

    boolean remove(Long id);

    boolean remove(List<Long> ids);

    @Transactional(readOnly = true)
    Optional<User> getUserWithAuthorities();

    Optional<User> findOneWithAuthoritiesByUsername(String userName);
}