package com.wjh.demo.business.test.controller;


import com.wjh.demo.business.test.entity.*;
import com.wjh.demo.business.test.entity.VO.*;
import com.wjh.demo.business.test.entity.DTO.*;
import com.wjh.demo.business.test.service.UserService ;
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


/**
 * 账号表 User
 * @author wjh
 * @since 2022-07-14
 */
@RestController
@RequestMapping("/user")
@Api(tags = "账号表")
@RequiredArgsConstructor
public class UserController {

    private final UserService  userService;


    @ApiOperation(value = "根据Id获取详情")
    @GetMapping("/getDetailById")
    public R<UserVO> getDetailById(@RequestParam("id") Integer id) {
        UserVO data = userService.getDetailById(id);
        return R.ok(data);
    }

    @ApiOperation(value = "查询列表 分页")
    @GetMapping("/pageList")
    public R<PageResult<UserVO>> pageList(UserQueryDTO dto, PageWrapper pageWrapper) {
        PageResult<UserVO> pageResult = userService.listVO(dto,pageWrapper);
        return R.ok(pageResult);
    }

    @ApiOperation(value = "新增")
    @PostMapping("/save")
    public R addSave(@RequestBody UserAddDTO data) {
        return userService.add(data) ? R.ok() : R.error();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/edit")
    public R editSave(@RequestBody UserEditDTO data) {
         return userService.edit(data) ? R.ok() : R.error();
    }

    @ApiOperation(value = "删除")
    @PostMapping("/remove")
    public R remove(@RequestBody IdDTO dto) {
        return userService.remove(dto.getId()) ? R.ok() : R.error();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchRemove")
    public R batchRemove(@RequestBody IdsDTO dto) {
        return userService.remove(dto.getIds()) ? R.ok() : R.error();
    }

}