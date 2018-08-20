package com.pinyougou.util;

import java.util.List;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;


/**
   * @author 
   * @date 
   * @version 
   */
public class BeanMapper {

	private static MapperFacade mapper = null;

	static {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapper = mapperFactory.getMapperFacade();

	}

	/**
	
	  * map(基于Dozer转换对象的类型.)
	  * TODO(基于Dozer转换对象的类型.)
	
	  * @Title: map
	  * @Description: TODO
	  * @param source
	  * @param destinationClass
	  * @return   
	  * @author 
	  * @since
	  * @throws
	  */
	public static <S, D> D map(S source, Class<D> destinationClass) {
		return mapper.map(source, destinationClass);
	}

	/**
	
	  * mapList(基于Dozer转换Collection中对象的类型.)
	  * TODO(这里描述这个方法适用条件 – 可选)
	
	  * @Title: mapList
	  * @Description: TODO
	  * @param sourceList
	  * @param destinationClass
	  * @return   
	  * @author 
	  * @since
	  * @throws
	  */
	public static <S, D> List<D> mapList(Iterable<S> sourceList, Class<D> destinationClass) {
		return mapper.mapAsList(sourceList, destinationClass);
	}
}