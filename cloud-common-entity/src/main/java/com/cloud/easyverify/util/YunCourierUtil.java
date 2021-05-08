package com.cloud.easyverify.util;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName: com.cloud.easyverify.util
 * @ClassName: YunCourierUtil
 * @Description: This is YunCourierUtil class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 10:17
 */
@Component
public class YunCourierUtil {
    private static final String appId = "1018";
    private static final String token = "89905f63c0818cfb6812e279d002b78e";

    public static boolean sendEmail(String to, String title, String msg) {
        String result = HttpUtil.post("https://courier-api.iskwen.com/api/easyMail", "applyId=" + appId + "&token=" + token + "&to=" + to + "&title=" + title + "&msg=" + msg);
        JSONObject jsonObject =JSONUtil.parseObj(result);
        return jsonObject.getInt("status") == 0;
    }

    public static boolean sendEmailByAsync(String to, String title, String msg) throws UnsupportedEncodingException {
        CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
        httpclient.start();

        System.out.println(" caller thread id is : " + Thread.currentThread().getId());
        HttpPost httpPost = new HttpPost("https://courier-api.iskwen.com/api/easyMail");
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("applyId", appId));
        nvps.add(new BasicNameValuePair("token", token));
        nvps.add(new BasicNameValuePair("to", to));
        nvps.add(new BasicNameValuePair("title", title));
        nvps.add(new BasicNameValuePair("msg", msg));
        //设置参数到请求对象中
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        httpclient.execute(httpPost, new FutureCallback<HttpResponse>() {
            @Override
            public void completed(final HttpResponse response) {
                System.out.println(" callback thread id is : " + Thread.currentThread().getId());
                try {
                    String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                    System.out.println(" response content is : " + content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void failed(final Exception ex) {
                System.out.println(" callback thread id is : " + Thread.currentThread().getId());
            }
            @Override
            public void cancelled() {
                System.out.println(" callback thread id is : " + Thread.currentThread().getId());
            }

        });
        return true;
    }
}
