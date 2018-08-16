package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pinyougou.entity.SeckillOrder;
import com.pinyougou.mapper.SeckillOrderMapper;
import com.pinyougou.sellergoods.service.SeckillOrderService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@Service
public class SeckillOrderServiceImpl extends ServiceImpl<SeckillOrderMapper, SeckillOrder> implements SeckillOrderService {
	
}
