package com.kangkang.config;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.kangkang.poji.User;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexAction;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.aggregations.metrics.sum.SumAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author zhangkangkang created on 2021/1/10 3:58 下午
 */
public class RestHigh {

    @Resource(name = "restHighLevelClient")
    private RestHighLevelClient restHighLevelClient;

    // 创建索引
    public void createIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("push_channel_five_minute");
        CreateIndexResponse response = restHighLevelClient
                .indices().create(request, RequestOptions.DEFAULT);

    }

    public void getIndex(){
        //获取索引
        GetIndexRequest getIndexRequest = new GetIndexRequest();
        //删除索引
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest();

    }

    //操作文档
    public void CRUDDocument() throws IOException {
        // 创建请求对象
        User zhang = User.builder().name("zhang").age(11).build();
        // 创建请求
        IndexRequest request = new IndexRequest("index");

        //规则： put /index/_doc/id
        request.id("1");
        request.timeout(TimeValue.timeValueSeconds(1));

        // 数据放入
        request.source(JSON.toJSONString(zhang), XContentType.JSON);

        // 客户端发送请求
        restHighLevelClient.index(request,RequestOptions.DEFAULT);
    }

    //批量插入
    public void bulkInsert() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        ArrayList<User> users = Lists.newArrayList();
        for (int i = 0; i < users.size(); i++) {
            bulkRequest.add(
                    new IndexRequest("index")
                            .id(""+i)
                            .source(JSON.toJSONString(users.get(i)),XContentType.JSON));
        }
        restHighLevelClient.bulk(bulkRequest,RequestOptions.DEFAULT);
    }

    //查询
    public void search() throws IOException {

        //查询条件：
        QueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "kangkang");

        // 搜索条件
        SearchRequest searchRequest = new SearchRequest("index");

        // 构建搜索
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(termQueryBuilder);
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(1);

        searchRequest.source(searchSourceBuilder);

        // 请求
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
    }

    //聚合查询
    public void searchSum() throws IOException {

        SumAggregationBuilder sumAggregationBuilder = new SumAggregationBuilder();
        // 请求
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
    }
}
