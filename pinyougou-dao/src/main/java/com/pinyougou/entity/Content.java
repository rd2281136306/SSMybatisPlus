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
@TableName("tb_content")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Content extends Model<Content> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 内容类目ID
     */
	@TableField("category_id")
	private Long categoryId;
    /**
     * 内容标题
     */
	private String title;
    /**
     * 链接
     */
	private String url;
    /**
     * 图片绝对路径
     */
	private String pic;
    /**
     * 状态
     */
	private String status;
    /**
     * 排序
     */
	@TableField("sort_order")
	private Integer sortOrder;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
