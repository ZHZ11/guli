package com.zhou.gulimail.gulimallthirdparty;

import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
class GulimallThirdPartyApplicationTests {
    @Autowired
    private OSSClient ossClient;

    @Test
    void contextLoads() throws FileNotFoundException {
        FileInputStream file = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\尚硅谷谷粒商城电商项目\\docs\\pics\\oppo.png"));
        ossClient.putObject("guli-mall-zhou", "test.png", file);
        System.out.println("上传文件成功");
    }

}
