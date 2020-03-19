package com.paradise.all4me.utils;


import com.paradise.all4me.domain.User;
import com.paradise.all4me.security.MyToken;

import java.security.Principal;
import java.util.Date;

/**
 * 额外的工具类
 *
 * @author Paradise
 */
public class CommonUtils {
    public static String dealPassword(String password) {
        char[] chars = password.toCharArray();
        int len = chars.length;
        char[] newChars = new char[len];
        for (int i = 0; i < len; i++) {
            if (i < 2 || i >= len - 2) {
                newChars[i] = chars[i];
            } else {
                newChars[i] = '*';
            }
        }
        return new String(newChars);
    }

    public static Integer getUserId(Principal principal) {
        return ((MyToken) principal).getUserId();
    }

    public static User getUser(Principal principal) {
        return ((MyToken) principal).getUser();
    }


    public static void main(String[] args) {
        System.out.println(dealPassword("paradise"));
    }

    /**
     * 比较当前时间和目标时间，是否超出限定天数
     * 用于判断是否超出有效期 days
     *
     * @param target 目标时间
     * @param days   限定天数
     * @return true 超出 false 未超出
     */
    public static boolean compareDate(Date target, int days) {
        long s = System.currentTimeMillis() - target.getTime();
        return s / (1000 * 60 * 24) > days;
    }

}
