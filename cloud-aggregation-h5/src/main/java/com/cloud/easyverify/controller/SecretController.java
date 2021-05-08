package com.cloud.easyverify.controller;


import com.cloud.easyverify.feign.SecretFeignService;
import com.cloud.easyverify.result.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.easyverify.controller
 * @ClassName: SecretController
 * @Description: This is SecretController class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 11:30
 */
@CrossOrigin
@RestController
@RequestMapping("/v1/api/h5/secret")
@Validated
public class SecretController {
    @Autowired
    private SecretFeignService secretFeignService;

    @RequestMapping("/create")
    public MyResult create(@RequestHeader("Authorization") String authorization, Date expireTime, @NotNull String remark) {
        return secretFeignService.create(authorization,expireTime,remark);
    }

    @RequestMapping("/listSecret")
    public MyResult listSecret(@RequestHeader("Authorization") String authorization, int page, @Max(1000) int size, String keyword, int type, int state, String sortName, String sortType) {
        return secretFeignService.listSecret(authorization,page,size,keyword,type,state,sortName,sortType);
    }

    @RequestMapping("/delete")
    public MyResult delete(@RequestHeader("Authorization") String authorization, @Min(1) int id) {
        return secretFeignService.delete(authorization,id);
    }

    @RequestMapping("/modify")
    public MyResult modify(@RequestHeader("Authorization") String authorization, @Min(1) int id,Date expireTime, @NotNull String remark) {
        return secretFeignService.modify(authorization,id,expireTime,remark);
    }
    @RequestMapping("/changeState")
    public MyResult changeState(@RequestHeader("Authorization") String authorization, @Min(1) int id,int state) {
        return secretFeignService.changeState(authorization,id,state);
    }
    @RequestMapping("/getBySecret")
    public MyResult getBySecret(String secretStr) {
        return secretFeignService.getBySecret(secretStr);
    }
}
