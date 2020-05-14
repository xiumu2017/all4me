package com.paradise.think.enum19;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author Paradise
 */
public enum ConstantSpecificMethod {
    /**
     * 获取时间
     */
    DATE_TIME {
        @Override
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        @Override
        String getInfo() {
            return System.getenv("PATH");
        }
    },
    VERSION {
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod c : values()) {
            System.out.println(c.getInfo());
        }
    }
}
