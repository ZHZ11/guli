package com.zhou.gulimail.product.controller;

import java.util.Arrays;
import java.util.Map;

import com.zhou.gulimail.product.vo.SpuSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zhou.gulimail.product.entity.SpuInfoEntity;
import com.zhou.gulimail.product.service.SpuInfoService;
import com.zhou.common.utils.PageUtils;
import com.zhou.common.utils.R;



/**
 * spu信息
 *
 * @author zhouhaizhan
 * @email 1363003594@qq.com
 * @date 2022-07-23 15:48:15
 */
@RestController
@RequestMapping("product/spuinfo")
public class SpuInfoController {
    @Autowired
    private SpuInfoService spuInfoService;

    @GetMapping("/skuId/{id}")
    public R getSkuInfoBySkuId(@PathVariable("id") Long skuId){

        SpuInfoEntity entity = spuInfoService.getSpuInfoBySkuId(skuId);
        return R.ok();
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = spuInfoService.queryPageByCondition(params);

        return R.ok().put("page", page);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SpuSaveVo vo){
        //spuInfoService.save(spuInfo);
        spuInfoService.save(vo);

        return R.ok();
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SpuInfoEntity spuInfo = spuInfoService.getById(id);

        return R.ok().put("spuInfo", spuInfo);
    }

    /**
     * 保存
     */
//    @RequestMapping("/save")
//    public R save(@RequestBody SpuInfoEntity spuInfo){
//		spuInfoService.save(spuInfo);
//
//        return R.ok();
//    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SpuInfoEntity spuInfo){
		spuInfoService.updateById(spuInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		spuInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
