package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pinyougou.entity.GoodsDesc;
import com.pinyougou.mapper.GoodsDescMapper;
import com.pinyougou.sellergoods.service.GoodsDescService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@Service
public class GoodsDescServiceImpl extends ServiceImpl<GoodsDescMapper, GoodsDesc> implements GoodsDescService {
	
}
