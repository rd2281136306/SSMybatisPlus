package com.pinyougou.entity;

import com.baomidou.mybatisplus.enums.IdType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@TableName("tb_freight_template")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class FreightTemplate extends Model<FreightTemplate> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 商家ID
     */
	@TableField("seller_id")
	private String sellerId;
    /**
     * 是否默认   （‘Y’是   'N'否）
     */
	@TableField("is_default")
	private String isDefault;
    /**
     * 模版名称
     */
	private String name;
    /**
     * 发货时间（1:12h  2:24h  3:48h  4:72h  5:7d 6:15d ）
     */
	@TableField("send_time_type")
	private String sendTimeType;
    /**
     * 统一价格
     */
	private BigDecimal price;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
