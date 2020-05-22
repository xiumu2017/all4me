package com.paradise.think.ops3;

/**
 * @author Paradise
 */
public class BitMoveOps {
    public static void main(String[] args) {
//        int x = -0xaa;
//        System.out.println(Integer.toBinaryString(x));
//        System.out.println(Integer.toBinaryString(x << 2));
//        System.out.println(Integer.toBinaryString(x << 1));
//        System.out.println(Integer.toBinaryString(x >> 1));
//        moveAll();
        for (int i = 0; i < 128; i++) {
            showCharHex((char) i);
        }
    }

    /**
     * 以一个最高有效位为 1 的二进制数字开始，
     * 用有符号右移操作符对其进行右移，
     * 直至所有的二进制位都被移出为止
     */
    private static void moveAll() {
        int x = 0x7fffffff;
        System.out.println(x);
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toHexString(x));
        for (int i = 0; i < 31; i++) {
            System.out.println(Integer.toBinaryString(x >>= 1));
        }
    }

    private static void showCharHex(char c) {
        System.out.println("Char: " + c);
        System.out.println(Integer.toBinaryString(c));
        System.out.println(Character.valueOf(c).hashCode() + "  " + (int) c);
        System.out.println("-----------");
    }

    private static void compareString(String s1, String s2) {
        System.out.println(s1 == s2);
        System.out.println(s1 != s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode() > s2.hashCode());
    }
}

