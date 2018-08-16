package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pinyougou.entity.User;
import com.pinyougou.mapper.UserMapper;
import com.pinyougou.sellergoods.service.UserService;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	
}
