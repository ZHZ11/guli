package com.zhou.gulimail.product.dao;

import com.zhou.gulimail.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author zhouhaizhan
 * @email 1363003594@qq.com
 * @date 2022-07-23 15:48:15
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
