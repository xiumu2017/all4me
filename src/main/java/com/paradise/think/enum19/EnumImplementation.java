package com.paradise.think.enum19;

import java.util.Random;

/**
 * @author Paradise
 */
enum Status implements Generator<Status> {
    /**
     * yes
     */
    Yes,
    /**
     * no
     */
    No, NotSure, Ques;
    private Random random = new Random(59);
    private static Random rand = new Random(159);

    /**
     * 随机产生
     *
     * @return T 随机
     */
    @Override
    public Status next() {
        int r = random.nextInt(values().length);
        System.out.println(r);
        return values()[r];
    }

    static Status rand() {
        int r = rand.nextInt(values().length);
        System.out.println("static" + r);
        return values()[r];
    }
}

/**
 * @author Paradise
 */
public class EnumImplementation {
    private static void printNext(Generator generator) {
        System.out.println(generator.next());
    }

    private static void next() {
        System.out.println(Status.rand());
    }

    public static void main(String[] args) {
        Status status = Status.Yes;
        for (int i = 0; i < 7; i++) {
            printNext(status);
            next();
            System.out.println("---");
        }
    }
}
