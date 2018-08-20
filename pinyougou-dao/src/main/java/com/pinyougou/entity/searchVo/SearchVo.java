package com.pinyougou.entity.searchVo;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchVo implements Serializable {

    private static final long serialVersionUID = 1L;
    
	public int pageSize = 10;
	public int pageNo = 1;

	public SearchVo(int pageSize) {
		setPageSize(pageSize);
	}

}
