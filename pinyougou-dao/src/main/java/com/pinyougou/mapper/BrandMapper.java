package com.pinyougou.mapper;

import com.pinyougou.entity.Brand;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
public interface BrandMapper extends BaseMapper<Brand> {

	public List<Brand> getBrandList();

}