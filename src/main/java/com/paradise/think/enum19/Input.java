package com.paradise.think.enum19;

import java.util.Random;

/**
 * 状态机
 *
 * @author Paradise
 */
public enum Input {
    /**
     * NICKEL
     */
    NICKEL(5),
    DIME(10),
    QUARTER(25),
    DOLLAR(100),
    TOOTHPASTE(200),
    CHIPS(75),
    SODA(100),
    SOAP(50),
    ABORT_TRANSACTION {
        @Override
        public int amount() {
            throw new RuntimeException("");
        }
    },
    STOP {
        @Override
        public int amount() {
            throw new RuntimeException("");
        }
    };
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
