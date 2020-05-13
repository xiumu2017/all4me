package com.paradise.think.enum19;

import static com.paradise.think.enum19.Season.*;
import static com.paradise.think.utils.CommonUtils.print;
import static com.paradise.think.utils.CommonUtils.println;

/**
 * @author Paradise
 */
public class EnumClass {

    public static void main(String[] args) {
        for (Season season : Season.values()) {
            print(season, "ordinal：", season.ordinal());
            println(season.compareTo(Fall));
            println(season.equals(Winter));
            println(season == Summer);
            println(season.getDeclaringClass());
            println(season.getClass());
            println(season.name());
            println("----------------------------------------");
        }

        Enum anEnum = Enum.valueOf(Season.class, "Spring");
        println(anEnum.toString());
    }

}
