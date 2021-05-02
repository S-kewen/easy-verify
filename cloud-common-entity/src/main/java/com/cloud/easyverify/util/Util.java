package com.cloud.easyverify.util;

/**
 * @PackageName: com.cloud.easyverify.util
 * @ClassName: Util
 * @Description: This is Util class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-02 23:53
 */
public class Util {
    public static String sort(String sortName, String sortType) {
        String result = "";
        if (sortName != null && sortName != "") {
            result = sortName;
            if (sortType != null && sortType != "") {
                result += " " + sortType;
            }
        }
        return result;
    }
}
