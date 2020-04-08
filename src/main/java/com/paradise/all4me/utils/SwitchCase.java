package com.paradise.all4me.utils;

/**
 * @author Paradise
 */
public class SwitchCase {
    public static void main(String[] args) {
        fun(null);
    }

    protected static void fun(String condition) {
        switch (condition) {
            case "f1":
                System.out.println("fff");
                break;
            case "":
                System.out.println("zzz");
                break;
            default:
                System.out.println("ooo");
                break;
        }

    }
}
