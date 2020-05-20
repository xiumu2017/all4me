package com.paradise.think.obj2;

import com.paradise.think.obj2.init.Base;

/**
 * @author Paradise
 */
public class StaticDemo {
    private int id;
    static Base base = new Base();

    public StaticDemo(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        StaticDemo demo1 = new StaticDemo(1);
        StaticDemo demo2 = new StaticDemo(2);
        StaticDemo demo3 = new StaticDemo(3);
        System.out.println(demo1.base == demo2.base);
        System.out.println(demo2.base == demo3.base);
        System.out.println(StaticDemo.base == demo1.base);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
