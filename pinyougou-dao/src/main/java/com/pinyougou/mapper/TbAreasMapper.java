package com.pinyougou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.pinyougou.pojo.TbAreas;
import com.pinyougou.pojo.TbAreasExample;

public interface TbAreasMapper extends BaseMapper<TbAreas> {
	
    int countByExample(TbAreasExample example);

    int deleteByExample(TbAreasExample example);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(TbAreas record);

    List<TbAreas> selectByExample(TbAreasExample example);

    TbAreas selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbAreas record, @Param("example") TbAreasExample example);

    int updateByExample(@Param("record") TbAreas record, @Param("example") TbAreasExample example);

    int updateByPrimaryKeySelective(TbAreas record);

    int updateByPrimaryKey(TbAreas record);
    
}