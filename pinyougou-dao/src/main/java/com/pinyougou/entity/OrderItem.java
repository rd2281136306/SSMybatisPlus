package com.pinyougou.entity;

import java.math.BigDecimal;
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
@TableName("tb_order_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class OrderItem extends Model<OrderItem> {

    private static final long serialVersionUID = 1L;

	private Long id;
    /**
     * 商品id
     */
	@TableField("item_id")
	private Long itemId;
    /**
     * SPU_ID
     */
	@TableField("goods_id")
	private Long goodsId;
    /**
     * 订单id
     */
	@TableField("order_id")
	private Long orderId;
    /**
     * 商品标题
     */
	private String title;
    /**
     * 商品单价
     */
	private BigDecimal price;
    /**
     * 商品购买数量
     */
	private Integer num;
    /**
     * 商品总金额
     */
	@TableField("total_fee")
	private BigDecimal totalFee;
    /**
     * 商品图片地址
     */
	@TableField("pic_path")
	private String picPath;
	@TableField("seller_id")
	private String sellerId;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
