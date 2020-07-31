package com.july.pet.common;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: july
 * @date: 2020/7/31 14:17
 * @description:
 */
public interface BaseMapper<DO extends BaseDO,Example> {
    long countByExample(Example example);

    int deleteByExample(Example example);

    int deleteByPrimaryKey(Long id);

    int insert(DO record);

    int insertSelective(DO record);

    List<DO> selectByExample(Example example);

    DO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DO record, @Param("example") Example example);

    int updateByExample(@Param("record") DO record, @Param("example") Example example);

    int updateByPrimaryKeySelective(DO record);

    int updateByPrimaryKey(DO record);
}
