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
 * 省份信息表
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@TableName("tb_provinces")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Provinces extends Model<Provinces> {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 省份ID
     */
	private String provinceid;
    /**
     * 省份名称
     */
	private String province;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
