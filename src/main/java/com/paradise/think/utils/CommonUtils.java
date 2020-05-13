package com.paradise.think.utils;

/**
 * @author Paradise
 */
public class CommonUtils {
    public static void println(Object... strings) {
        for (Object s : strings) {
            System.out.println(s);
        }
    }

    public static void print(Object... strings) {
        for (Object s : strings) {
            System.out.print(s);
            System.out.print(" ");
        }
    }
}
