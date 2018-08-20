package com.pinyougou.entity.searchVo;

import java.io.Serializable;

import com.pinyougou.entity.Brand;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BrandSearchVo extends SearchVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Brand brand;
	
	public BrandSearchVo(){
		
	}

}
