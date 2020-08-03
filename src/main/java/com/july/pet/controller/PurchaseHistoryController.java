package com.july.pet.controller;

import com.july.pet.bo.PurchaseHistoryBO;
import com.july.pet.common.BaseQueryPageDTO;
import com.july.pet.common.PetPage;
import com.july.pet.common.Result;
import com.july.pet.dto.QueryPurchaseHistoryDTO;
import com.july.pet.form.CreatePurchaseHistoryForm;
import com.july.pet.service.PurchaseHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author: july
 * @date: 2020/8/3 15:46
 * @description:
 */
@Api(tags = "购买记录信息")
@RestController
@RequestMapping("purchaseHistory")
public class PurchaseHistoryController {

    @Autowired
    private PurchaseHistoryService purchaseHistoryService;

    @GetMapping("page")
    @ApiOperation("分页查询购买记录")
    public Result<PetPage<PurchaseHistoryBO>> page(QueryPurchaseHistoryDTO dto) {
        return Result.success(purchaseHistoryService.query(dto));
    }

    @PostMapping
    @ApiOperation("新增购买记录")
    public Result<PurchaseHistoryBO> page(@Validated @RequestBody CreatePurchaseHistoryForm form) {
        return Result.success(purchaseHistoryService.create(form.toBO()));
    }

}
