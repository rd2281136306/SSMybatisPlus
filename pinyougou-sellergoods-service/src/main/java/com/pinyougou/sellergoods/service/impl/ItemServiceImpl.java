package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pinyougou.entity.Item;
import com.pinyougou.mapper.ItemMapper;
import com.pinyougou.sellergoods.service.ItemService;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {
	
}
