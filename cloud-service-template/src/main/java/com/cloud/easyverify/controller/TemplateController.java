package com.cloud.easyverify.controller;

import com.cloud.easyverify.entity.Template;
import com.cloud.easyverify.entity.Token;
import com.cloud.easyverify.result.MyResult;
import com.cloud.easyverify.result.ResultMsg;
import com.cloud.easyverify.service.TemplateService;
import com.cloud.easyverify.util.TokenUtil;
import com.cloud.easyverify.util.Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.easyverify.controller
 * @ClassName: TemplateController
 * @Description: This is TemplateController class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-04 18:19
 */
@RestController
@RequestMapping("/v1/api/template")
@Validated
public class TemplateController {
    @Autowired
    private TemplateService templateService;
    @Autowired
    private TokenUtil tokenUtil;

    @RequestMapping("/create")
    public MyResult create(@RequestHeader("Authorization") String authorization, @NotNull String title, @NotNull String content, int codeType, @Max(100) int codeLen, @Min(1) int tryTotal, @Min(1) int validTime, @NotNull String remark) {
        if (content.indexOf("$(#code)") == -1) {
            return new MyResult(ResultMsg.TEMPLATE_SYMBOLNOTEXIST);
        }
        Token token = tokenUtil.parseToken(authorization);
        if (token != null) {
            Template template = new Template();
            template.setUid(token.getId());
            template.setType(1);
            template.setState(1);
            template.setTitle(title);
            template.setContent(content);
            template.setCodeType(codeType);
            template.setCodeLen(codeLen);
            template.setTryTotal(tryTotal);
            template.setValidTime(validTime);
            template.setRemark(remark);
            int count = templateService.insertOne(template);
            if (count > 0) {
                return new MyResult(ResultMsg.SUCCESS);
            } else {
                return new MyResult(ResultMsg.TEMPLATE_CREATEFAIL);
            }
        } else {
            return new MyResult(ResultMsg.USER_ACCESSERROR);
        }
    }

    @RequestMapping("/listTemplate")
    public MyResult listTemplate(@RequestHeader("Authorization") String authorization, int page, @Max(1000) int size, String keyword, int type, int state, String sortName, String sortType) {
        Token token = tokenUtil.parseToken(authorization);
        if (token != null) {
            Template template = new Template();
            template.setUid(token.getId());
            template.setType(type);
            template.setState(state);
            template.setContent(keyword);
            PageHelper.startPage(page, size, Util.sort(sortName, sortType));
            List<Map<String, Object>> list = templateService.list(template);
            PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
            return new MyResult(ResultMsg.SUCCESS, pageInfo);
        } else {
            return new MyResult(ResultMsg.USER_ACCESSERROR);
        }
    }

    @RequestMapping("/delete")
    public MyResult delete(@RequestHeader("Authorization") String authorization, @Min(1) int id) {
        Token token = tokenUtil.parseToken(authorization);
        if (token != null) {
            Template template = new Template();
            template.setId(id);
            template.setUid(token.getId());
            int count = templateService.deleteOne(template);
            if (count > 0) {
                return new MyResult(ResultMsg.SUCCESS);
            } else {
                return new MyResult(ResultMsg.TEMPLATE_DELETEFAIL);
            }
        } else {
            return new MyResult(ResultMsg.USER_ACCESSERROR);
        }
    }

    @RequestMapping("/modify")
    public MyResult modify(@RequestHeader("Authorization") String authorization, @Min(1) int id, @NotNull String title, @NotNull String content, int codeType,@Max(100) int codeLen, @Min(1) int tryTotal, @Min(1) int validTime,@NotNull String remark) {
        if (content.indexOf("$(#code)") == -1) {
            return new MyResult(ResultMsg.TEMPLATE_SYMBOLNOTEXIST);
        }
        Token token = tokenUtil.parseToken(authorization);
        if (token != null) {
            Template template = new Template();
            template.setId(id);
            template.setUid(token.getId());
            template.setTitle(title);
            template.setContent(content);
            template.setCodeType(codeType);
            template.setCodeLen(codeLen);
            template.setTryTotal(tryTotal);
            template.setValidTime(validTime);
            template.setRemark(remark);
            int count = templateService.updateOne(template);
            if (count > 0) {
                return new MyResult(ResultMsg.SUCCESS);
            } else {
                return new MyResult(ResultMsg.TEMPLATE_UPDATEFAIL);
            }
        } else {
            return new MyResult(ResultMsg.USER_ACCESSERROR);
        }
    }

    @RequestMapping("/changeState")
    public MyResult changeState(@RequestHeader("Authorization") String authorization, @Min(1) int id, int state) {
        Token token = tokenUtil.parseToken(authorization);
        if (token != null) {
            Template template = new Template();
            template.setId(id);
            template.setUid(token.getId());
            template.setState(state);
            int count = templateService.updateOne(template);
            if (count > 0) {
                return new MyResult(ResultMsg.SUCCESS);
            } else {
                return new MyResult(ResultMsg.TEMPLATE_UPDATEFAIL);
            }
        } else {
            return new MyResult(ResultMsg.USER_ACCESSERROR);
        }
    }

    @RequestMapping("/selectOne")
    public MyResult selectOne(@Min(1) long id, @Min(1) long uid) {
        Template template = new Template();
        template.setId(id);
        template.setUid(uid);
        template = templateService.selectOne(template);
        if (template != null) {
            return new MyResult(ResultMsg.SUCCESS, template);
        } else {
            return new MyResult(ResultMsg.TEMPLATE_UPDATEFAIL);
        }
    }
}
