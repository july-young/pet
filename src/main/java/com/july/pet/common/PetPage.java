package com.july.pet.common;

import com.github.pagehelper.PageInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: july
 * @date: 2020/7/31 15:39
 * @description:
 */
@Getter
@Setter
public class PetPage<T> {

    private int page;

    private int size;

    private long total;

    private int pages;

    private List<T> list;

    public static <T> PetPage<T> getInstance(PageInfo<T> pageInfo) {
        PetPage petPage = new PetPage();
        petPage.setList(pageInfo.getList());
        petPage.setPage(pageInfo.getPageNum());
        petPage.setTotal(pageInfo.getTotal());
        petPage.setPages(pageInfo.getPages());
        petPage.setSize(pageInfo.getSize());
        return petPage;
    }
}
