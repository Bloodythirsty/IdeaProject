package utils;

import com.google.common.base.Charsets;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * @author xulei created on 2019-08-12 10:26
 */

public class HttpClientUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    /**
     * 连接超时时间ms
     */
    private static final int CONNECT_TIMEOUT = 30000;
    /**
     * 获取数据的超时时间ms
     */
    private static final int SOCKET_TIMEOUT = 30000;
    /**
     * 从连接池中获取可用连接的时间ms
     */
    private static final int CONNECTION_REQUEST_TIMEOUT = 30000;
    /**
     * 连接池的最大连接数
     */
    private static final int POOL_MAX_TOTAL = 100;
    /**
     * 每一个路由的最大连接数
     */
    private static final int POOL_MAX_PRE_ROUTE = 100;
    /**
     * 可用空闲连接过期时间ms,重用空闲连接时会先检查是否空闲时间超过这个时间，如果超过，释放socket重新建立
     */
    private static final int POOL_CONNECTION_CHECK_TIMEOUT = 30000;
    /**
     * 请求超时配置
     */
    private static final RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(CONNECT_TIMEOUT)
            .setSocketTimeout(SOCKET_TIMEOUT)
            .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
            .build();
    /**
     * 配置连接池
     */
    private static final PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();

    static {
        connectionManager.setMaxTotal(POOL_MAX_TOTAL);
        connectionManager.setDefaultMaxPerRoute(POOL_MAX_TOTAL);
        connectionManager.setValidateAfterInactivity(POOL_CONNECTION_CHECK_TIMEOUT);
    }

    /**
     * POST请求
     *
     * @param url
     * @return
     */
    // public static String doDriverPaymentJsonPost(String url, String jsonParam, WardenAuthClient wardenAuthClient) {
    //     CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(requestConfig)
    //             .setConnectionManager(connectionManager).build();
    //
    //     HttpPost httpPost = new HttpPost(url);
    //     wardenAuthClient.signHttpClient(httpPost, null, 100);
    //
    //     CloseableHttpResponse response = null;
    //     try {
    //         httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
    //         StringEntity requestEntity = new StringEntity(jsonParam, Charsets.UTF_8);
    //         requestEntity.setContentEncoding("UTF-8");
    //         httpPost.setEntity(requestEntity);
    //
    //         response = client.execute(httpPost);
    //         if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
    //             return EntityUtils.toString(response.getEntity(), Charsets.UTF_8);
    //         }
    //
    //         throw new RuntimeException("doPost status code is " + response.getStatusLine().getStatusCode());
    //     } catch (IOException e) {
    //         throw new RuntimeException(e);
    //     } finally {
    //         try {
    //             if (response != null) {
    //                 response.close();
    //             }
    //         } catch (IOException e) {
    //             logger.error("response close error:", e);
    //         }
    //     }
    // }

    /**
     * GET请求
     *
     * @param url
     * @return
     */
    public static String doGet(String url) {
        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager).build();

        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(response.getEntity(), Charsets.UTF_8);
            }

            throw new RuntimeException("doGet status code is " + response.getStatusLine().getStatusCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                logger.error("response close error:", e);
            }
        }
    }


    public static String post(String url,String body) {
        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager).build();

        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(5000)
                .setConnectTimeout(5000)
                .setSocketTimeout(6000)
                .build();

        httpPost.setConfig(requestConfig);
        httpPost.setHeader("Connection","keep-alive");
        httpPost.setHeader("Accept-Charset","utf-8");
        httpPost.setHeader("content-Type", ContentType.APPLICATION_JSON.getMimeType());

        try {
            StringEntity entity = new StringEntity(body,"UTF-8");
            httpPost.setEntity(entity);

            CloseableHttpResponse response = client.execute(httpPost);
            HttpEntity resEntity = response.getEntity();
            String json = EntityUtils.toString(resEntity);
            response.close();
            return json;
        }catch (Exception e){
            httpPost.releaseConnection();
            logger.error("post error " ,e);
            return null;
        }

    }
}
