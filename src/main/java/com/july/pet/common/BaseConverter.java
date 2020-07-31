package com.july.pet.common;

import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: july
 * @date: 2020/7/31 10:51
 * @description:
 */
public interface BaseConverter<BO, DO> {

    /**
     * 转换成BO
     *
     * @param d do对象
     * @return
     */
    BO toBO(DO d);

    default List<BO> toBO(List<DO> list) {
        return list == null ? Collections.emptyList() : list.stream().map(this::toBO).collect(Collectors.toList());
    }

    /**
     * 转换成DO
     *
     * @param b bo对象
     * @return
     */
    DO toDO(BO b);

    default List<DO> toDO(List<BO> list) {
        return list == null ? Collections.emptyList() : list.stream().map(this::toDO).collect(Collectors.toList());
    }

}
