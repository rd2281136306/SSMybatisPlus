package com.pinyougou.manager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.pinyougou.entity.Brand;
import com.pinyougou.entity.searchVo.BrandSearchVo;
import com.pinyougou.result.Result;
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
public class BrandController extends BaseController {
	
	public Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Reference
    private BrandService brandService;

    /**
     * 
     * @return
     */
    @RequestMapping("/findAll")
	public List<Brand> findAll(){
       
    	logger.info("进来了");
    	List<Brand> brandList = brandService.selectList(new EntityWrapper<Brand>());
//      List<Brand> brandList = brandService.findAll();
        
        return brandList;
        
    }
    
    /**
     * 
     * @return
     */
    @RequestMapping("/findPage")
	public Page<Brand> findPage(@RequestBody BrandSearchVo searchVo){
    	
    	logger.info("进来了");
    	Page<Brand> brandList = brandService.selectListPage(searchVo);

        return brandList;
        
    }
    
    /**
     * 
     * @return
     */
    @RequestMapping("/addBrand")
	public Result addBrand(@RequestBody Brand brand){
    	
    	try {
    		
    		brandService.insert(brand);
    		
    		return renderSuccess("添加品牌成功");
    		
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("方法路由：{},方法参数：{},异常message：{}", "/brand/addBrand", e.getMessage());
			return renderError("添加品牌的出错！");
			
		}
    	
    }
	
    /**
     * 
     * @return
     */
    @RequestMapping("/findBrandById")
    public Brand findBrandById(Long brandId) {
    	
    	Brand brand = brandService.selectById(brandId);
    	
    	return brand;
    	
    }
    
    /**
     * 
     * @return
     */
    @RequestMapping("/updateBrandById")
    public Result updateBrandById(@RequestBody Brand brand) {
    	
    	try {
    		
			brandService.updateById(brand);
			return renderSuccess("修改品牌成功");
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("方法路由：{},方法参数：{},异常message：{}", "/brand/updateBrandById", e.getMessage());
			return renderError("修改品牌失败");
			
		}
    	
    }
    
    /**
     * 
     * @return
     */
    @RequestMapping("/deleteByIds")
    public Result deleteByIds(Long [] ids) {
    	
    	try {
			for (Long id : ids) {
				brandService.deleteById(id);
			}
    		return renderSuccess("删除成功");
    		
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("方法路由：{},方法参数：{},异常message：{}", "/brand/deleteByIds", e.getMessage());
			return renderSuccess("删除失败");
		}
    	
    }
}
