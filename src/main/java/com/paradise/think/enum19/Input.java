package com.paradise.think.enum19;

import java.util.Random;

/**
 * 状态机
 *
 * @author Paradise
 */
public enum Input {
    ;
    int value;

    Input(int value) {
        this.value = value;
    }

    Input() {
    }

    int amount() {
        return value;
    }

    static Random random = new Random(47);

    public static Input randomSelect() {
        return values()[random.nextInt(values().length - 1)];
    }
}
