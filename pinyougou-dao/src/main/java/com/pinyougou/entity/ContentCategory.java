package com.pinyougou.entity;

import com.baomidou.mybatisplus.enums.IdType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 内容分类
 * </p>
 *
 * @author R.Ding
 * @since 2018-08-14
 */
@TableName("tb_content_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class ContentCategory extends Model<ContentCategory> {

    private static final long serialVersionUID = 1L;

    /**
     * 类目ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 分类名称
     */
	private String name;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
