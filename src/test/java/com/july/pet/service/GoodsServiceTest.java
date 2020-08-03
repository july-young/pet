package com.july.pet.service;

import com.july.pet.bo.GoodsBO;
import com.july.pet.common.PetSpecConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @author: july
 * @date: 2020/8/3 11:29
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsServiceTest {
    @Autowired
    private GoodsService goodsService;

    @Test
    public void create() {

        GoodsBO goodsBO = new GoodsBO();
        goodsBO.setName("鱼肉猫粮");
        goodsBO.setBrand("apple");
        goodsBO.setCategory("catFood");
        goodsBO.setSpeciality("sweet");
        goodsBO.setWeight(15);
        goodsBO.setImgUrls(Arrays.asList("https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3472225673,1999680163&fm=26&gp=0.jpg"));
        goodsService.create(goodsBO);
    }


}
