package com.zhou.gulimail.gulimailsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {

    public static final RequestOptions REQUEST_OPTIONS;

    static {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
        REQUEST_OPTIONS = builder.build();
    }

    @Bean
    public RestHighLevelClient getRestHighLevelClient() {
        return new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.117.130", 9200, "http")));
    }
}
