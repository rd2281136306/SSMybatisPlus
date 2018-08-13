package com.pinyougou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.pinyougou.pojo.TbCities;
import com.pinyougou.pojo.TbCitiesExample;

public interface TbCitiesMapper extends BaseMapper<TbCities> {
	
    int countByExample(TbCitiesExample example);

    int deleteByExample(TbCitiesExample example);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(TbCities record);

    List<TbCities> selectByExample(TbCitiesExample example);

    TbCities selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbCities record, @Param("example") TbCitiesExample example);

    int updateByExample(@Param("record") TbCities record, @Param("example") TbCitiesExample example);

    int updateByPrimaryKeySelective(TbCities record);

    int updateByPrimaryKey(TbCities record);
    
}