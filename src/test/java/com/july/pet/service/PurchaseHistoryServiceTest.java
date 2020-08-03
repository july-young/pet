package com.july.pet.service;

import com.july.pet.bo.GoodsBO;
import com.july.pet.bo.PurchaseHistoryBO;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Arrays;

/**
 * @author: july
 * @date: 2020/8/3 15:29
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PurchaseHistoryServiceTest {

    @Autowired
    private PurchaseHistoryService purchaseHistoryService;

    @Test
    public void createTest() {
        PurchaseHistoryBO purchaseHistoryBO = new PurchaseHistoryBO();
        purchaseHistoryBO.setUserId(1L);
        purchaseHistoryBO.setAmount(5);
        purchaseHistoryBO.setChannel("tianMao");
        purchaseHistoryBO.setPrice(1000);
        purchaseHistoryBO.setGoodsId(2L);
        String[] s = new String[]{};
        try {
            purchaseHistoryBO.setGmtBuy(DateUtils.parseDate("2020-10-10 00:01:02", new String[]{"YYYY-MM-DD HH:mm:ss"}));
            purchaseHistoryBO.setGmtBuy(DateUtils.parseDate("2020-11-10 00:01:02", new String[]{"YYYY-MM-DD HH:mm:ss"}));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        GoodsBO goodsBO = new GoodsBO();
        goodsBO.setName("鱼肉猫粮");
        goodsBO.setBrand("apple");
        goodsBO.setCategory("catFood");
        goodsBO.setSpeciality("sweet");
        goodsBO.setWeight(15);
        goodsBO.setImgUrls(Arrays.asList("https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3472225673,1999680163&fm=26&gp=0.jpg"));
        purchaseHistoryBO.setGoodsBO(goodsBO);
        purchaseHistoryService.create(purchaseHistoryBO);
    }
}
