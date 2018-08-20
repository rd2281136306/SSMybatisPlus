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
@TableName("tb_seckill_goods")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class SeckillGoods extends Model<SeckillGoods> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * spu ID
     */
	@TableField("goods_id")
	private Long goodsId;
    /**
     * sku ID
     */
	@TableField("item_id")
	private Long itemId;
    /**
     * 标题
     */
	private String title;
    /**
     * 商品图片
     */
	@TableField("small_pic")
	private String smallPic;
    /**
     * 原价格
     */
	private BigDecimal price;
    /**
     * 秒杀价格
     */
	@TableField("cost_price")
	private BigDecimal costPrice;
    /**
     * 商家ID
     */
	@TableField("seller_id")
	private String sellerId;
    /**
     * 添加日期
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 审核日期
     */
	@TableField("check_time")
	private Date checkTime;
    /**
     * 审核状态
     */
	private String status;
    /**
     * 开始时间
     */
	@TableField("start_time")
	private Date startTime;
    /**
     * 结束时间
     */
	@TableField("end_time")
	private Date endTime;
    /**
     * 秒杀商品数
     */
	private Integer num;
    /**
     * 剩余库存数
     */
	@TableField("stock_count")
	private Integer stockCount;
    /**
     * 描述
     */
	private String introduction;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
