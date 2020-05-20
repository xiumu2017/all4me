package com.paradise.think.obj2.init;

/**
 * 验证 Java 执行了默认初始化
 *
 * @author Paradise
 */
public class Base {
    boolean b;
    // \u0000 null
    char c;
    byte aByte;
    short aShort;
    int i;
    long l;
    float f;
    double aDouble;

    public static void main(String[] args) {
        Base base = new Base();
        System.out.println(base.b);
        System.out.println(base.c);
        System.out.println((int)base.c);
        System.out.println(base.aByte);
        System.out.println(base.aShort);
        System.out.println(base.i);
        System.out.println(base.l);
        System.out.println(base.f);
        System.out.println(base.aDouble);
    }
}
