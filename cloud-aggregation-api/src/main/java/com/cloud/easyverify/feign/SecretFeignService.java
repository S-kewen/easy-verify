package com.cloud.easyverify.feign;

import com.cloud.easyverify.result.MyResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * @PackageName: com.cloud.easyverify.feign
 * @ClassName: SecretFeignService
 * @Description: This is SecretFeignService interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 11:25
 */
@Component
@FeignClient(value = "cloud-service-secret")
public interface SecretFeignService {
    String URL = "/v1/api/secret";

    @RequestMapping(URL + "/create")
    MyResult create(@RequestHeader("Authorization") String authorization, @RequestParam("expireTime") Date expireTime, @RequestParam("remark") String remark);

    @RequestMapping(URL + "/listSecret")
    MyResult listSecret(@RequestHeader("Authorization") String authorization, @RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("keyword") String keyword, @RequestParam("type") int type, @RequestParam("state") int state, @RequestParam("sortName") String sortName, @RequestParam("sortType") String sortType);

    @RequestMapping(URL + "/delete")
    MyResult delete(@RequestHeader("Authorization") String authorization, @RequestParam("id") int id);

    @RequestMapping(URL + "/modify")
    MyResult modify(@RequestHeader("Authorization") String authorization, @RequestParam("id") int id, @RequestParam("expireTime") Date expireTime, @RequestParam("remark") String remark);

    @RequestMapping(URL + "/changeState")
    MyResult changeState(@RequestHeader("Authorization") String authorization, @RequestParam("id") int id, @RequestParam("state") int state);

    @RequestMapping(URL + "/getBySecret")
    MyResult getBySecret(@RequestParam("secretStr") String secretStr);
}

