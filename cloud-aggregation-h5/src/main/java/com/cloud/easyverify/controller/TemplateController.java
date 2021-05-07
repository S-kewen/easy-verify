package com.cloud.easyverify.controller;

import com.cloud.easyverify.feign.TemplateFeignService;
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

/**
 * @PackageName: com.cloud.easyverify.controller
 * @ClassName: TemplateController
 * @Description: This is TemplateController class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 15:17
 */
@CrossOrigin
@RestController
@RequestMapping("/v1/api/h5/template")
@Validated
public class TemplateController {
    @Autowired
    private TemplateFeignService templateFeignService;

    @RequestMapping("/create")
    public MyResult create(@RequestHeader("Authorization") String authorization, @NotNull String title, @NotNull String content, int codeType, @Max(100) int codeLen, @NotNull String remark) {
        return templateFeignService.create(authorization, title, content, codeType, codeLen, remark);
    }

    @RequestMapping("/listTemplate")
    public MyResult listTemplate(@RequestHeader("Authorization") String authorization, int page, @Max(1000) int size, String keyword, int type, int state, String sortName, String sortType) {
        return templateFeignService.listTemplate(authorization, page, size, keyword, type, state, sortName, sortType);
    }

    @RequestMapping("/delete")
    public MyResult delete(@RequestHeader("Authorization") String authorization, @Min(1) int id) {
        return templateFeignService.delete(authorization, id);
    }

    @RequestMapping("/modify")
    public MyResult modify(@RequestHeader("Authorization") String authorization, @Min(1) int id, @NotNull String title, @NotNull String content, int codeType, @Max(100) int codeLen, @NotNull String remark) {
        return templateFeignService.modify(authorization, id, title, content, codeType, codeLen, remark);
    }

    @RequestMapping("/changeState")
    public MyResult changeState(@RequestHeader("Authorization") String authorization, @Min(1) int id, int state) {
        return templateFeignService.changeState(authorization, id, state);
    }
}
