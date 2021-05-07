package com.cloud.easyverify.util;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.stereotype.Component;

/**
 * @PackageName: com.cloud.easyverify.util
 * @ClassName: YunCourierUtil
 * @Description: This is YunCourierUtil class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 10:17
 */
@Component
public class YunCourierUtil {
    private static final int appId = 1018;
    private static final String token = "89905f63c0818cfb6812e279d002b78e";

    public static boolean sendEmail(String to, String title, String msg) {
        String result = HttpUtil.post("https://courier-api.iskwen.com/api/easyMail", "applyId=" + appId + "&token=" + token + "&to=" + to + "&title=" + title + "&msg=" + msg);
        JSONObject jsonObject =JSONUtil.parseObj(result);
        return jsonObject.getInt("status") == 0;
    }
}
