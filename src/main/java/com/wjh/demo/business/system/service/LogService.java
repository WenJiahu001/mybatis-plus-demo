package com.wjh.demo.business.system.service;

import com.wjh.demo.business.system.entity.*;
import com.wjh.demo.business.system.entity.VO.*;
import com.wjh.demo.business.system.entity.DTO.*;
import com.wjh.demo.common.dto.IdDTO;
import com.wjh.demo.common.dto.IdsDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wjh.demo.common.vo.PageResult;
import com.wjh.demo.common.vo.PageWrapper;
import java.util.List;

import com.wjh.demo.common.vo.PageResult;
import com.wjh.demo.common.vo.PageWrapper;

/**
 *  服务类
 * @author wjh
 * @since 2022-07-15
 */
public interface LogService extends IService<Log> {

    PageResult<LogVO> listVO(LogQueryDTO dto,PageWrapper wrapper);

    List<LogVO> listVO(LogQueryDTO dto);

    LogVO getDetailById(Integer id);

    boolean add(LogAddDTO dto);

    boolean edit(LogEditDTO dto);

    boolean remove(Long id);

    boolean remove(List<Long> ids);
}