package com.zhou.gulimail.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.common.utils.PageUtils;
import com.zhou.gulimail.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author zhouhaizhan
 * @email 1363003594@qq.com
 * @date 2022-07-23 15:05:21
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

