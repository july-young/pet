package com.july.pet.controller;

import com.july.pet.bo.PetBO;
import com.july.pet.common.PetPage;
import com.july.pet.common.Result;
import com.july.pet.dto.QueryPetDTO;
import com.july.pet.form.CreatePetForm;
import com.july.pet.form.UpdatePetForm;
import com.july.pet.service.PetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author: july
 * @date: 2020/7/31 11:01
 * @description: 宠物api
 */
@Api("宠物信息")
@RestController
@RequestMapping("pet")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("page")
    @ApiOperation("分页查询宠物")
    public Result<PetPage<PetBO>> page(QueryPetDTO dto) {

        return Result.success(petService.query(dto));
    }

    @PostMapping
    @ApiOperation("创建宠物信息")
    public Result<PetBO> create(@RequestBody CreatePetForm form) {

        PetBO petBO = form.toBO();

        return Result.success(petService.create(petBO));
    }


    @PutMapping
    @ApiOperation("更新宠物信息")
    public Result<PetBO> update(@Validated @RequestBody UpdatePetForm form) {

        PetBO userBO = form.toBO();

        return Result.success(petService.update(userBO));
    }

    @GetMapping("{id}")
    @ApiOperation("查询宠物信息")
    public Result<PetBO> findById(@PathVariable Long id) {

        return Result.success(petService.query(id));
    }

    @DeleteMapping("{id}")
    @ApiOperation("删除宠物信息")
    public Result<Integer> remove(@PathVariable Long id) {

        return Result.success(petService.remove(id));
    }

}
