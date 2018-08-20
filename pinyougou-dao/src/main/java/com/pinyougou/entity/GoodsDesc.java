package com.pinyougou.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@TableName("tb_goods_desc")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class GoodsDesc extends Model<GoodsDesc> {

    private static final long serialVersionUID = 1L;

    /**
     * SPU_ID
     */
    @TableId("goods_id")
	private Long goodsId;
    /**
     * 描述
     */
	private String introduction;
    /**
     * 规格结果集，所有规格，包含isSelected
     */
	@TableField("specification_items")
	private String specificationItems;
    /**
     * 自定义属性（参数结果）
     */
	@TableField("custom_attribute_items")
	private String customAttributeItems;
	@TableField("item_images")
	private String itemImages;
    /**
     * 包装列表
     */
	@TableField("package_list")
	private String packageList;
    /**
     * 售后服务
     */
	@TableField("sale_service")
	private String saleService;

	@Override
	protected Serializable pkVal() {
		return this.goodsId;
	}

}
