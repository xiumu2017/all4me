package com.paradise.think.ops3;

/**
 * @author Paradise
 */
public class BitOps {
    public static void main(String[] args) {
        int x = 0xaa;
        int a = 0x55;

        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(a));

        System.out.println(x & a);
        System.out.println(Integer.toBinaryString(x & a));
        System.out.println(x | a);
        System.out.println(Integer.toBinaryString(x | a));
        System.out.println(x ^ a);
        System.out.println(Integer.toBinaryString(x ^ a));

        System.out.println(Integer.toBinaryString(~a));
        System.out.println(Integer.toBinaryString(~x));
        System.out.println(Integer.toHexString(~x));

    }
}

