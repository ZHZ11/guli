package com.zhou.gulimail.product.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zhou.gulimail.product.entity.CategoryEntity;
import com.zhou.gulimail.product.service.CategoryService;
import com.zhou.common.utils.R;



/**
 * 商品三级分类
 *
 * @author zhouhaizhan
 * @email 1363003594@qq.com
 * @date 2022-07-23 15:48:15
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list/tree")
    public R list(){
        return R.ok().put("data", this.categoryService.getCategoryTree());
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody List<Long> catIds){
        this.categoryService.deleteById(catIds);
        return R.ok();
    }

    @RequestMapping("/update/sort")
    public R saveUpdate(@RequestBody List<CategoryEntity> categoryEntityList) {
        this.categoryService.updateBatchById(categoryEntityList);
        return R.ok();
    }

}
