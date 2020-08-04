package com.july.pet.controller;

import com.july.pet.bo.GoodsItemBO;
import com.july.pet.common.PetPage;
import com.july.pet.common.Result;
import com.july.pet.dto.QueryGoodsItemDTO;
import com.july.pet.service.GoodsItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author: july
 * @date: 2020/8/4 09:57
 * @description:
 */
@Api(tags = "商品item")
@RestController
@RequestMapping("goodsItem")
public class GoodsItemController {

    @Autowired
    private GoodsItemService goodsItemService;

    @GetMapping("page")
    @ApiOperation("分页查询商品item")
    public Result<PetPage<GoodsItemBO>> page(QueryGoodsItemDTO dto) {
        PetPage<GoodsItemBO> page = goodsItemService.query(dto);
        return Result.success(page);
    }

    @GetMapping("{id}")
    @ApiOperation("查询购买记录的商品item")
    public Result<GoodsItemBO> items(@PathVariable Long id) {

        return Result.success(goodsItemService.query(id));
    }

    @PutMapping("open/{id}")
    @ApiOperation("新增开袋")
    public Result<GoodsItemBO> openGoodsItem( @PathVariable Long id,Date openDate) {
        return Result.success(goodsItemService.openGoodsItem(id,openDate));
    }


}
