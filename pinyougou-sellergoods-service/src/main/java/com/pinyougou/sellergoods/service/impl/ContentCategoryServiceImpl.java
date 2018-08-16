package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pinyougou.entity.ContentCategory;
import com.pinyougou.mapper.ContentCategoryMapper;
import com.pinyougou.sellergoods.service.ContentCategoryService;

/**
 * <p>
 * 内容分类 服务实现类
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@Service
public class ContentCategoryServiceImpl extends ServiceImpl<ContentCategoryMapper, ContentCategory> implements ContentCategoryService {
	
}
