package com.zhou.gulimail.gulimallthirdparty.controller;

import com.zhou.common.utils.R;
import com.zhou.gulimail.gulimallthirdparty.service.OSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("oss")
public class OSSController {

    @Autowired
    private OSSService ossService;

    @RequestMapping(value = "policy", method = RequestMethod.GET)
    public R getPolicy() {
        return ossService.getPolicy();
    }
}
