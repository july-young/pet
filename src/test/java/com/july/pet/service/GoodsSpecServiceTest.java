package com.july.pet.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * @author: july
 * @date: 2020/8/3 11:04
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsSpecServiceTest {
    @Autowired
    private GoodsSpecService goodsSpecService;

    @Test
    public void testQuerySpec() {
        String result = goodsSpecService.querySpec("catFood");
        System.out.println(result);
    }

    @Test
    public void testQuerySpecs() {
        Map<String, String> map = goodsSpecService.querySpecs("goodsCategory");
        map.forEach((x, y) -> {
            System.out.println(x + ":" + y);
        });
    }


}
