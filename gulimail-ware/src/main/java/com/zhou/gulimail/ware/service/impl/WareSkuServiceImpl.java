package com.zhou.gulimail.ware.service.impl;

import com.zhou.common.utils.R;
import com.zhou.gulimail.ware.feign.ProductFeignService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.common.utils.PageUtils;
import com.zhou.common.utils.Query;

import com.zhou.gulimail.ware.dao.WareSkuDao;
import com.zhou.gulimail.ware.entity.WareSkuEntity;
import com.zhou.gulimail.ware.service.WareSkuService;

import javax.annotation.Resource;


@Service("wareSkuService")
public class WareSkuServiceImpl extends ServiceImpl<WareSkuDao, WareSkuEntity> implements WareSkuService {

    @Resource
    private ProductFeignService productFeignService;
    @Resource
    private WareSkuDao wareSkuDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<WareSkuEntity> queryWapper = new QueryWrapper<>();
        String  skuId = (String) params.get("skuId");
        if (!StringUtils.isEmpty(skuId)){
            queryWapper.eq("sku_id",skuId);
        }

        String  wareId = (String) params.get("wareId");
        if (!StringUtils.isEmpty(wareId)){
            queryWapper.eq("ware_id",wareId);
        }
        IPage<WareSkuEntity> page = this.page(
                new Query<WareSkuEntity>().getPage(params),
                queryWapper
        );

        return new PageUtils(page);
    }

    @Override
    public void addStock(Long skuId, Long wareId, Integer skuNum) {
        //1、判断如果还没有库存记录新增
        List<WareSkuEntity> entities = this.list(new QueryWrapper<WareSkuEntity>().eq("sku_id", skuId).eq("ware_id", wareId));
        if (entities == null || entities.size() ==0 ){
            WareSkuEntity wareSkuEntity = new WareSkuEntity();
            wareSkuEntity.setId(skuId);
            wareSkuEntity.setStock(skuNum);
            wareSkuEntity.setWareId(wareId);
            wareSkuEntity.setStockLocked(0);
            //TODO 远程查询sku的名字  如果失败，整个事务不需要回滚

            // 1、自己catch异常
            //2、TODO 还可以用什么办法让异常出现以后不回滚？高级
            try{
                R info = productFeignService.info(skuId);
                if (info.getCode() == 0){
                    Map<String,Object> data = (Map<String, Object>) info.get("skuInfo");
                    wareSkuEntity.setSkuName((String) data.get("skuName"));
                }
            }catch (Exception e){

            }
            wareSkuDao.insert(wareSkuEntity);
        }else {
            wareSkuDao.addStock(skuId, wareId, skuNum);
        }

    }
}
