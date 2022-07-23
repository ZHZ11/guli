package com.zhou.gulimail.member.dao;

import com.zhou.gulimail.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author zhouhaizhan
 * @email 1363003594@qq.com
 * @date 2022-07-23 16:14:31
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
