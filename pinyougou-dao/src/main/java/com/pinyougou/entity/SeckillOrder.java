package com.pinyougou.entity;

import java.math.BigDecimal;
import java.util.Date;
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
@TableName("tb_seckill_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class SeckillOrder extends Model<SeckillOrder> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private Long id;
    /**
     * 秒杀商品ID
     */
	@TableField("seckill_id")
	private Long seckillId;
    /**
     * 支付金额
     */
	private BigDecimal money;
    /**
     * 用户
     */
	@TableField("user_id")
	private String userId;
    /**
     * 商家
     */
	@TableField("seller_id")
	private String sellerId;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 支付时间
     */
	@TableField("pay_time")
	private Date payTime;
    /**
     * 状态
     */
	private String status;
    /**
     * 收货人地址
     */
	@TableField("receiver_address")
	private String receiverAddress;
    /**
     * 收货人电话
     */
	@TableField("receiver_mobile")
	private String receiverMobile;
    /**
     * 收货人
     */
	private String receiver;
    /**
     * 交易流水
     */
	@TableField("transaction_id")
	private String transactionId;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
