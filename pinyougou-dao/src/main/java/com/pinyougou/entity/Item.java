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
 * 商品表
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@TableName("tb_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Item extends Model<Item> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id，同时也是商品编号
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 商品标题
     */
	private String title;
    /**
     * 商品卖点
     */
	@TableField("sell_point")
	private String sellPoint;
    /**
     * 商品价格，单位为：元
     */
	private BigDecimal price;
	@TableField("stock_count")
	private Integer stockCount;
    /**
     * 库存数量
     */
	private Integer num;
    /**
     * 商品条形码
     */
	private String barcode;
    /**
     * 商品图片
     */
	private String image;
    /**
     * 所属类目，叶子类目
     */
	private Long categoryId;
    /**
     * 商品状态，1-正常，2-下架，3-删除
     */
	private String status;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;
	@TableField("item_sn")
	private String itemSn;
	@TableField("cost_pirce")
	private BigDecimal costPirce;
	@TableField("market_price")
	private BigDecimal marketPrice;
	@TableField("is_default")
	private String isDefault;
	@TableField("goods_id")
	private Long goodsId;
	@TableField("seller_id")
	private String sellerId;
	@TableField("cart_thumbnail")
	private String cartThumbnail;
	private String category;
	private String brand;
	private String spec;
	private String seller;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
