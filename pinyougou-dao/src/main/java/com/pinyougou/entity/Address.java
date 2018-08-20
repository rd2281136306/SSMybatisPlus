package com.pinyougou.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@TableName("tb_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Address extends Model<Address> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 用户ID
     */
	@TableField("user_id")
	private String userId;
    /**
     * 省
     */
	@TableField("province_id")
	private String provinceId;
    /**
     * 市
     */
	@TableField("city_id")
	private String cityId;
    /**
     * 县/区
     */
	@TableField("town_id")
	private String townId;
    /**
     * 手机
     */
	private String mobile;
    /**
     * 详细地址
     */
	private String address;
    /**
     * 联系人
     */
	private String contact;
    /**
     * 是否是默认 1默认 0否
     */
	@TableField("is_default")
	private String isDefault;
    /**
     * 备注
     */
	private String notes;
    /**
     * 创建日期
     */
	@TableField("create_date")
	private Date createDate;
    /**
     * 别名
     */
	private String alias;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
