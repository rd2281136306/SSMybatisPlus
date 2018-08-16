package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pinyougou.entity.Brand;
import com.pinyougou.mapper.BrandMapper;
import com.pinyougou.sellergoods.service.BrandService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

	@Autowired
	private BrandMapper brandMapper;
	
	@Override
	public List<Brand> findAll() {
		return brandMapper.getBrandList();
	}
	
}
