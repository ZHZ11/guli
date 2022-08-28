package com.zhou.gulimail.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.common.utils.PageUtils;
import com.zhou.gulimail.product.entity.AttrEntity;
import com.zhou.gulimail.product.vo.AttrGroupRelationVo;
import com.zhou.gulimail.product.vo.AttrVo;
import com.zhou.gulimail.product.vo.AttrResponseVo;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author zhouhaizhan
 * @email 1363003594@qq.com
 * @date 2022-07-23 15:48:15
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, Long catelogId);

    void saveAttr(AttrVo attrVo);

    AttrResponseVo getAttrInfo(Long attrId);

    void updateInfo(AttrVo attr);

    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String type);

    List<AttrEntity> getRelationAttr(Long attrgroupId);

    void deletRelation(List<AttrGroupRelationVo> vos);

    PageUtils getNoAttrRelation(Map<String, Object> params, Long attrgroupId);
}

