package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pinyougou.entity.Specification;
import com.pinyougou.mapper.SpecificationMapper;
import com.pinyougou.sellergoods.service.SpecificationService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@Service
public class SpecificationServiceImpl extends ServiceImpl<SpecificationMapper, Specification> implements SpecificationService {
	
}
