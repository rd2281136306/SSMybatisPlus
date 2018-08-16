package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pinyougou.entity.Areas;
import com.pinyougou.mapper.AreasMapper;
import com.pinyougou.sellergoods.service.AreasService;

/**
 * <p>
 * 行政区域县区信息表 服务实现类
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@Service
public class AreasServiceImpl extends ServiceImpl<AreasMapper, Areas> implements AreasService {
	
}
