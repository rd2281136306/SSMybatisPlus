package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pinyougou.entity.Provinces;
import com.pinyougou.mapper.ProvincesMapper;
import com.pinyougou.sellergoods.service.ProvincesService;

/**
 * <p>
 * 省份信息表 服务实现类
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@Service
public class ProvincesServiceImpl extends ServiceImpl<ProvincesMapper, Provinces> implements ProvincesService {
	
}
