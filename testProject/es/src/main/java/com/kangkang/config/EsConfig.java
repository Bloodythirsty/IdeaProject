package com.kangkang.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wusong
 */
@Configuration
public class EsConfig {

    @Value("${es.host}")
    private String host;

    @Value("${es.port}")
    private int port;

    @Value("${es.protocol}")
    private String protocol;

    @Value("${es.connect_timeout}")
    private int connectTimeout;

    @Value("${es.socket_timeout}")
    private int socketTimeout;

    @Value("${es.connect_request_timeout}")
    private int connectRequestTimeout;

    @Value("${es.max_retry_timeout}")
    private int maxRetryTimeout;

    @Value("${es.app_id}")
    private String appId;

    @Value("${es.app_secret}")
    private String appSecret;

    @Bean(name = "restHighLevelClient")
    public RestHighLevelClient getRestHighLevelClient() {
        return new RestHighLevelClient(RestClient
                .builder(new HttpHost(host, port, protocol))
                .setBasicAuth(appId,appSecret)
                .setRequestConfigCallback(requestConfigBuilder ->{
                    requestConfigBuilder.setConnectTimeout(connectTimeout);
                    requestConfigBuilder.setSocketTimeout(socketTimeout);
                    requestConfigBuilder.setConnectionRequestTimeout(connectRequestTimeout);
                    return requestConfigBuilder;
                }).setMaxRetryTimeoutMillis(maxRetryTimeout));
    }

}
