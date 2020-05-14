package com.paradise.think.enum19;

import java.util.Random;

/**
 * 随机选取
 *
 * @author Paradise
 */
public class Enums {
    private static Random random = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> tc) {
        return random(tc.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[random.nextInt(values.length)];
    }
}

enum Test {
    /**
     * 1
     */
    One, Two, Three, Four, Five, Six;
}

class RandomTest {
    public static void main(String[] args) {
        System.out.println(Enums.random(Test.class));
    }
}
