package com.pinyougou.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 行政区域县区信息表
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@TableName("tb_areas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Areas extends Model<Areas> {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 区域ID
     */
	private String areaid;
    /**
     * 区域名称
     */
	private String area;
    /**
     * 城市ID
     */
	private String cityid;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
