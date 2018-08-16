package com.pinyougou.entity;

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
@TableName("tb_pay_log")
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


	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Long getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTradeState() {
		return tradeState;
	}

	public void setTradeState(String tradeState) {
		this.tradeState = tradeState;
	}

	public String getOrderList() {
		return orderList;
	}

	public void setOrderList(String orderList) {
		this.orderList = orderList;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	@Override
	protected Serializable pkVal() {
		return this.outTradeNo;
	}

}
