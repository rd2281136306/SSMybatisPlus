package com.pinyougou.entity;

import com.baomidou.mybatisplus.enums.IdType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@TableName("tb_specification_option")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class SpecificationOption extends Model<SpecificationOption> {

    private static final long serialVersionUID = 1L;

    /**
     * 规格项ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 规格项名称
     */
	@TableField("option_name")
	private String optionName;
    /**
     * 规格ID
     */
	@TableField("spec_id")
	private Long specId;
    /**
     * 排序值
     */
	private Integer orders;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
