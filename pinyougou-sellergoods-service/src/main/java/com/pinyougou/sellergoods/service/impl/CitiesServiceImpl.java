package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pinyougou.entity.Cities;
import com.pinyougou.mapper.CitiesMapper;
import com.pinyougou.sellergoods.service.CitiesService;

/**
 * <p>
 * 行政区域地州市信息表 服务实现类
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@Service
public class CitiesServiceImpl extends ServiceImpl<CitiesMapper, Cities> implements CitiesService {
	
}
