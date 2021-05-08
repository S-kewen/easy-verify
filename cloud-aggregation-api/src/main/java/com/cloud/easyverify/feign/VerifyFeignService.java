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
 * @ClassName: VerifyFeignService
 * @Description: This is VerifyFeignService interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 23:40
 */
@Component
@FeignClient(value = "cloud-service-verify")
public interface VerifyFeignService {
    String URL = "/v1/api/verify";

    @RequestMapping(URL + "/create")
    MyResult create(@RequestParam("uid") long uid, @RequestParam("sid") long sid, @RequestParam("tid") long tid, @RequestParam("type") int type, @RequestParam("state") int state, @RequestParam("tryTotal") int tryTotal, @RequestParam("ip") String ip, @RequestParam("code") String code, @RequestParam("email") String email, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("expireTime") Date expireTime, @RequestParam("remark") String remark);

    @RequestMapping(URL + "/listVerify")
    MyResult listVerify(@RequestHeader("Authorization") String authorization, @RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("keyword") String keyword, @RequestParam("type") int type, @RequestParam("state") int state, @RequestParam("sortName") String sortName, @RequestParam("sortType") String sortType);

    @RequestMapping(URL + "/delete")
    MyResult delete(@RequestHeader("Authorization") String authorization, @RequestParam("id") int id);

    @RequestMapping(URL + "/changeState")
    MyResult changeState(@RequestHeader("Authorization") String authorization, @RequestParam("id") int id, @RequestParam("state") int state);

    @RequestMapping(URL + "/getByUUId")
    MyResult getByUUId(@RequestParam("uuid") String uuid);

    @RequestMapping(URL + "/modifyByUUId")
    MyResult modifyByUUId(@RequestParam("uuid") String uuid, @RequestParam("state") int state, @RequestParam("tryTotal") int tryTotal);

}
