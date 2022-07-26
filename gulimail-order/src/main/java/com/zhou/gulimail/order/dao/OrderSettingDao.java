package com.zhou.gulimail.order.dao;

import com.zhou.gulimail.order.entity.OrderSettingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单配置信息
 * 
 * @author zhouhaizhan
 * @email 1363003594@qq.com
 * @date 2022-07-23 15:05:21
 */
@Mapper
public interface OrderSettingDao extends BaseMapper<OrderSettingEntity> {
	
}
