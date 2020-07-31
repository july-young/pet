package com.july.pet.controller;

import com.july.pet.bo.UserBO;
import com.july.pet.common.PetPage;
import com.july.pet.common.Result;
import com.july.pet.dto.QueryUserDTO;
import com.july.pet.form.CreateUserForm;
import com.july.pet.form.UpdateUserForm;
import com.july.pet.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author: july
 * @date: 2020/7/31 10:30
 * @description:
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("page")
    @ResponseBody
    @ApiOperation("分页查询用户")
    public Result<PetPage<UserBO>> page(QueryUserDTO dto) {

        return Result.success(userService.query(dto));
    }

    @PostMapping
    @ResponseBody
    @ApiOperation("创建用户")
    public Result<UserBO> create(@RequestBody CreateUserForm form) {

        UserBO userBO = form.toBO();

        return Result.success(userService.create(userBO));
    }


    @PutMapping
    @ResponseBody
    @ApiOperation("更新用户")
    public Result<UserBO> update(@Validated @RequestBody UpdateUserForm form) {

        UserBO userBO = form.toBO();

        return Result.success(userService.update(userBO));
    }

}
