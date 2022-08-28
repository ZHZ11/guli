package com.zhou.gulimail.coupon.feign;

import com.zhou.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("member")
public interface MemberFeignService {

    @RequestMapping("/member/member/list")
    public R test();
}
