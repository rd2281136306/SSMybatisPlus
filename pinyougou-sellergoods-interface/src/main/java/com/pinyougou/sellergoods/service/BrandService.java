package com.pinyougou.sellergoods.service;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.pinyougou.entity.Brand;
import com.pinyougou.entity.searchVo.BrandSearchVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
public interface BrandService extends IService<Brand> {
	
	public List<Brand> findAll();

	public Page<Brand> selectListPage(BrandSearchVo searchVo);
	
}
