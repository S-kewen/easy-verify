package com.cloud.easyverify.util;

import cn.hutool.core.util.RandomUtil;

import java.util.Random;

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

    public static String getCode(int type, int len) {
        String result = "";
        if (type == 1) {
            result = RandomUtil.randomNumbers(len);
        } else if (type == 2) {
            result = getRandomString("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789",len);
        } else if (type == 3) {
            result = RandomUtil.randomString(len);
        } else if (type == 4) {
            result = RandomUtil.randomString(len).toUpperCase();
        } else if (type == 5) {
            result = getRandomString("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ",len);
        } else if (type == 6) {
            result = getRandomString("abcdefghijklmnopqrstuvwxyz",len);
        }else{
            result = getRandomString("ABCDEFGHIJKLMNOPQRSTUVWXYZ",len);
        }
        return result;
    }

    private static String getRandomString(String dict,int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(dict.length());
            sb.append(dict.charAt(number));
        }
        return sb.toString();
    }
}
