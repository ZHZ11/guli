package com.zhou.gulimail.gulimailsearch;

import com.zhou.gulimail.gulimailsearch.config.ElasticSearchConfig;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import java.io.IOException;

@SpringBootTest
class GulimailSearchApplicationTests {

    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Test
    void contextLoads() throws IOException {
        IndexRequest indexRequest = new IndexRequest("user");
        indexRequest.id("1");
        indexRequest.source(XContentType.JSON,"username", "zhou", "age", 23);
        IndexResponse index = restHighLevelClient.index(indexRequest, ElasticSearchConfig.REQUEST_OPTIONS);
        System.out.println(index);
    }

}
