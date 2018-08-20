package com.pinyougou.entity;

import com.baomidou.mybatisplus.enums.IdType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 行政区域地州市信息表
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@TableName("tb_cities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Cities extends Model<Cities> {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 城市ID
     */
	private String cityid;
    /**
     * 城市名称
     */
	private String city;
    /**
     * 省份ID
     */
	private String provinceid;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
