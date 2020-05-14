package com.paradise.think.enum19;

/**
 * 使用接口组织枚举；达到分类的目的
 *
 * @author Paradise
 */
public interface Food {
    enum MainFood implements Food {
        /**
         * 面包
         */
        Bread, Rice, Sandwich, Hamburger;
    }

    enum Coffee implements Food {
        /**
         * 纯咖啡
         */
        PureCoffee, Blank, WHITE;
    }
}

class TypeOfFood {
    public static void main(String[] args) {
        Food food = Food.MainFood.Bread;
        food = Food.Coffee.WHITE;
        food = Food.MainFood.values()[0];
    }
}

enum Course {
    /**
     * 主食
     */
    MainFood(Food.MainFood.class),
    Coffee(Food.Coffee.class);

    private Food[] values;

    Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food select() {
        return Enums.random(values);
    }
}

class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                Food food = course.select();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }
}