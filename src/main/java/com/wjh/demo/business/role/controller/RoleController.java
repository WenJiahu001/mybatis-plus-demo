package com.wjh.demo.business.role.controller;


import com.wjh.demo.business.role.entity.*;
import com.wjh.demo.business.role.entity.VO.*;
import com.wjh.demo.business.role.entity.DTO.*;
import com.wjh.demo.business.role.service.RoleService ;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.wjh.demo.common.dto.IdDTO;
import com.wjh.demo.common.dto.IdsDTO;
import com.wjh.demo.common.vo.PageResult;
import com.wjh.demo.common.vo.PageWrapper;
import com.wjh.demo.common.vo.R;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;



/**
 * demo Role
 * @author wjh
 * @since 2022-07-29
 */
@RestController
@RequestMapping("/role")
@Api(tags = "demo")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService  roleService;


    @ApiOperation(value = "根据Id获取详情")
    @GetMapping("/getDetailById")
    public R<RoleVO> getDetailById(@RequestParam("id") Integer id) {
        RoleVO data = roleService.getDetailById(id);
        return R.ok(data);
    }

    @ApiOperation(value = "查询列表 分页")
    @GetMapping("/pageList")
    public R<PageResult<RoleVO>> pageList(RoleQueryDTO dto, PageWrapper pageWrapper) {
        PageResult<RoleVO> pageResult = roleService.listVO(dto,pageWrapper);
        return R.ok(pageResult);
    }

    @ApiOperation(value = "新增")
    @PostMapping("/add")
    public R add(@Valid @RequestBody RoleAddDTO data) {
        return roleService.add(data) ? R.ok() : R.error();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/edit")
    public R edit(@Valid @RequestBody RoleEditDTO data) {
         return roleService.edit(data) ? R.ok() : R.error();
    }

    @ApiOperation(value = "删除")
    @PostMapping("/remove")
    public R remove(@Valid @RequestBody IdDTO dto) {
        return roleService.remove(dto.getId()) ? R.ok() : R.error();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchRemove")
    public R batchRemove(@Valid @RequestBody IdsDTO dto) {
        return roleService.remove(dto.getIds()) ? R.ok() : R.error();
    }

}