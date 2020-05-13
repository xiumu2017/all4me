package com.paradise.think.enum19;

/**
 * @author Paradise
 */
public enum Season {

    /**
     * 春天
     */
    Spring,
    Summer,
    Fall,
    Winter;

    Season() {
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(Spring.toString());
    }
}
