package com.paradise.think.enum19;

import java.util.EnumMap;
import java.util.Map;

interface Command {
    /**
     * action
     */
    void action();
}

/**
 * EnumMap
 *
 * @author Paradise
 */
public class EnumMaps {

    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> enumMap = new EnumMap<>(AlarmPoints.class);
        enumMap.put(AlarmPoints.KITCHEN, () -> System.out.println(" Kitchen fire! "));
        enumMap.put(AlarmPoints.LOBBY, () -> System.out.println(" lobby fire! "));
        enumMap.put(AlarmPoints.OFFICE, () -> System.out.println(" Office fire! "));

        for (Map.Entry<AlarmPoints, Command> entry : enumMap.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().action();
        }
        try {
            enumMap.get(AlarmPoints.STAIR1).action();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
