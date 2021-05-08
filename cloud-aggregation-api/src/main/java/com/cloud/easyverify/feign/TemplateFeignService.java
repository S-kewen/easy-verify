package com.cloud.easyverify.feign;

import com.cloud.easyverify.result.MyResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @PackageName: com.cloud.easyverify.feign
 * @ClassName: TemplateFeignService
 * @Description: This is TemplateFeignService interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 15:05
 */
@Component
@FeignClient(value = "cloud-service-template")
public interface TemplateFeignService {
    String URL = "/v1/api/template";

    @RequestMapping(URL + "/create")
    MyResult create(@RequestHeader("Authorization") String authorization, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("codeType") int codeType, @RequestParam("codeLen") int codeLen, @RequestParam("tryTotal") int tryTotal, @RequestParam("validTime") int validTime, @RequestParam("remark") String remark);

    @RequestMapping(URL + "/listTemplate")
    MyResult listTemplate(@RequestHeader("Authorization") String authorization, @RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("keyword") String keyword, @RequestParam("type") int type, @RequestParam("state") int state, @RequestParam("sortName") String sortName, @RequestParam("sortType") String sortType);

    @RequestMapping(URL + "/delete")
    MyResult delete(@RequestHeader("Authorization") String authorization, @RequestParam("id") int id);

    @RequestMapping(URL + "/modify")
    MyResult modify(@RequestHeader("Authorization") String authorization, @RequestParam("id") int id, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("codeType") int codeType, @RequestParam("codeLen") int codeLen, @RequestParam("tryTotal") int tryTotal, @RequestParam("validTime") int validTime, @RequestParam("remark") String remark);

    @RequestMapping(URL + "/changeState")
    MyResult changeState(@RequestHeader("Authorization") String authorization, @RequestParam("id") int id, @RequestParam("state") int state);

    @RequestMapping(URL + "/selectOne")
    MyResult selectOne(@RequestParam("id") long id, @RequestParam("uid") long uid);
}
