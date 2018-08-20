package com.pinyougou.entity;

import java.util.Date;
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
@TableName("tb_pay_log")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class PayLog extends Model<PayLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 支付订单号
     */
    @TableId("out_trade_no")
	private String outTradeNo;
    /**
     * 创建日期
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 支付完成时间
     */
	@TableField("pay_time")
	private Date payTime;
    /**
     * 支付金额（分）
     */
	@TableField("total_fee")
	private Long totalFee;
    /**
     * 用户ID
     */
	@TableField("user_id")
	private String userId;
    /**
     * 交易号码
     */
	@TableField("transaction_id")
	private String transactionId;
    /**
     * 交易状态
     */
	@TableField("trade_state")
	private String tradeState;
    /**
     * 订单编号列表
     */
	@TableField("order_list")
	private String orderList;
    /**
     * 支付类型
     */
	@TableField("pay_type")
	private String payType;

	@Override
	protected Serializable pkVal() {
		return this.outTradeNo;
	}

}
