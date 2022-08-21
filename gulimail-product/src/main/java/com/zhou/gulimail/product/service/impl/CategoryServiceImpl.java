package com.zhou.gulimail.product.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.zhou.gulimail.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.common.utils.PageUtils;
import com.zhou.common.utils.Query;

import com.zhou.gulimail.product.dao.CategoryDao;
import com.zhou.gulimail.product.entity.CategoryEntity;
import com.zhou.gulimail.product.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> getCategoryTree() {
        List<CategoryEntity> list = this.list();
        List<CategoryEntity> first = list.stream().filter(categoryEntity -> categoryEntity.getParentCid() == 0).map((categoryEntity) -> {
            categoryEntity.setChildren(getChildren(categoryEntity, list));
            return categoryEntity;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());
        return first;
    }

    @Override
    public void deleteById(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
    }

    @Override
    public void findCatelogPath(Long categoryId, List<Long> catelogPath) {
        catelogPath.add(categoryId);
        CategoryEntity categoryEntity = baseMapper.selectById(categoryId);
        if (categoryEntity.getParentCid() != 0) findCatelogPath(categoryEntity.getParentCid(), catelogPath);
    }

    @Transactional
    @Override
    public void updateDetail(CategoryEntity category) {
        this.updateById(category);
        if (!StringUtils.isEmpty(category.getName())) categoryBrandRelationService.updateCategory(category.getCatId(), category.getName());
    }

    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        return all.stream().filter(categoryEntity -> categoryEntity.getParentCid() == root.getCatId()).map((categoryEntity) -> {
            categoryEntity.setChildren(getChildren(categoryEntity, all));
            return categoryEntity;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());
    }

}
