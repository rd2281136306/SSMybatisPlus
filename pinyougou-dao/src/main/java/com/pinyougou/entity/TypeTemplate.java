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
@TableName("tb_type_template")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class TypeTemplate extends Model<TypeTemplate> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 模板名称
     */
	private String name;
    /**
     * 关联规格
     */
	@TableField("spec_ids")
	private String specIds;
    /**
     * 关联品牌
     */
	@TableField("brand_ids")
	private String brandIds;
    /**
     * 自定义属性
     */
	@TableField("custom_attribute_items")
	private String customAttributeItems;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
