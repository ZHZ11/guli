package com.zhou.gulimail.product.service.impl;

import com.zhou.gulimail.product.entity.AttrAttrgroupRelationEntity;
import com.zhou.gulimail.product.service.AttrAttrgroupRelationService;
import com.zhou.gulimail.product.service.AttrGroupService;
import com.zhou.gulimail.product.service.CategoryService;
import com.zhou.gulimail.product.vo.AttrResponseVo;
import com.zhou.gulimail.product.vo.AttrVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.common.utils.PageUtils;
import com.zhou.common.utils.Query;

import com.zhou.gulimail.product.dao.AttrDao;
import com.zhou.gulimail.product.entity.AttrEntity;
import com.zhou.gulimail.product.service.AttrService;
import org.springframework.transaction.annotation.Transactional;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AttrGroupService attrGroupService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        QueryWrapper<AttrEntity> queryWrapper = new QueryWrapper<>();
        String key = (String) params.get("key");
        if (catelogId != 0) queryWrapper.eq("catelog_id", catelogId);
        if (!StringUtils.isEmpty(key)) {
            queryWrapper.and(query -> query.eq("attr_id", key).or().like("attr_name", key));
        }
        IPage<AttrEntity> page = this.page(new Query<AttrEntity>().getPage(params), queryWrapper);
        PageUtils pageUtils = new PageUtils(page);
//        List<AttrResponseVo> responseVos = page.getRecords().stream().map((attrEntity) -> {
//            attrEntity.get
//        }).collect(Collectors.toList());
        return pageUtils;
    }

    @Transactional
    @Override
    public void saveAttr(AttrVo attrVo) {
        AttrEntity attr = new AttrEntity();
        BeanUtils.copyProperties(attrVo, attr);
        this.save(attr);
        AttrAttrgroupRelationEntity attrAttrgroupRelation = new AttrAttrgroupRelationEntity();
        attrAttrgroupRelation.setAttrId(attr.getAttrId());
        attrAttrgroupRelation.setAttrGroupId(attrVo.getAttrGroupId());
        attrAttrgroupRelationService.save(attrAttrgroupRelation);
    }

}
