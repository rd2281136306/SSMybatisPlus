package com.pinyougou.manager.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.pinyougou.entity.Brand;
import com.pinyougou.sellergoods.service.BrandService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
	
	private Logger logger = Logger.getLogger(BrandController.class);
	
	@Reference
    private BrandService brandService;

    /**
     * 返回到JSP
     * @return
     */
    @RequestMapping("findAll")
	public List<Brand> findAll(){
       
    	logger.info("进来了");
        List<Brand> userList = brandService.selectList(new EntityWrapper<Brand>());
//      List<Brand> userList = brandService.findAll();
        
        return userList;
    }
	
}
