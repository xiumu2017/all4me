package com.paradise.think.ops3;

import java.util.Random;

/**
 * 算术操作符
 *
 * @author Paradise
 */
public class MathOps {
    public static void main(String[] args) {
        Random random = new Random(47);
        int i, j, k;
        j = random.nextInt(100) + 1;
        System.out.println("j: " + j);
        k = random.nextInt(100) + 1;
        System.out.println("k: " + k);
        System.out.println(k / j);
        System.out.println(k % j);
        System.out.println(j % k);

        float u, v;
        u = random.nextFloat();
        v = random.nextFloat();
        System.out.println(u + v);
        System.out.println(u - v);
        System.out.println(u / v);
        System.out.println(u * v);

        u += v;
        System.out.println(u);
        u -= v;
        System.out.println(u);
        u *= v;
        System.out.println(u);
        u /= v;
        System.out.println(u);
    }
}
