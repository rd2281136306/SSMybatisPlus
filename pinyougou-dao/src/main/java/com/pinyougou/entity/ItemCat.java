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
 * 商品类目
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@TableName("tb_item_cat")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class ItemCat extends Model<ItemCat> {

    private static final long serialVersionUID = 1L;

    /**
     * 类目ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 父类目ID=0时，代表的是一级的类目
     */
	@TableField("parent_id")
	private Long parentId;
    /**
     * 类目名称
     */
	private String name;
    /**
     * 类型id
     */
	@TableField("type_id")
	private Long typeId;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
