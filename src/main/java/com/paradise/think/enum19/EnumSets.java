package com.paradise.think.enum19;

import java.util.EnumSet;

enum AlarmPoints {
    /**
     * 位置
     */
    STAIR1,
    STAIR2,
    LOBBY,
    OFFICE,
    BATHROOM,
    UTILITY,
    KITCHEN
}

/**
 * EnumSet
 *
 * @author Paradise
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(AlarmPoints.BATHROOM);
        System.out.println(points);

        points.addAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.OFFICE));
        System.out.println(points);

        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(AlarmPoints.STAIR2, AlarmPoints.LOBBY));
        System.out.println(points);

        points.removeAll(EnumSet.range(AlarmPoints.UTILITY, AlarmPoints.KITCHEN));
        System.out.println(points);

        // 剩余的枚举
        points = EnumSet.complementOf(points);
        System.out.println(points);
    }
}
