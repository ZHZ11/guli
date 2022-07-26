package com.zhou.gulimail.coupon.dao;

import com.zhou.gulimail.coupon.entity.CouponHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 * 
 * @author zhouhaizhan
 * @email 1363003594@qq.com
 * @date 2022-07-23 16:11:48
 */
@Mapper
public interface CouponHistoryDao extends BaseMapper<CouponHistoryEntity> {
	
}
