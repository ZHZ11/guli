package com.zhou.gulimail.product.feign;

import com.zhou.common.to.SkuReductionTo;
import com.zhou.common.to.SpuBoundTo;
import com.zhou.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("coupon")
public interface CouponFeignService {


    /**
     * 1、couponFeignService.saveSpuBounds(spuBoundTo)
     *      1)、@RequestBody将这个对象转为json
     *      2)、找到gulimall-coupon服务，给/coupon/spubounds/save发送请求。将上一步转的json放在请求体的位置发送请求
     *      3）、对方服务收到请求请求体有json数据。
     *      (@RequestBody SpuBoundsEntity spuBoundTo)将请求体里的json转为SpuBoundsEntity
     * 只要json数据模型是兼容的。对方服务无需使用同一个to
     * @param spuBoundTo
     * @return
     */
    @PostMapping("/coupon/spubounds/save")
    R saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo);

    @PostMapping("/coupon/skufullreduction/saveinfo")
    R saveSkuReduction(SkuReductionTo skuReductionTo);
}
