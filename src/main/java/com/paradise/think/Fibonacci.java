package com.paradise.think;

public class Fibonacci {

    public static void main(String[] args) {
        fibonacci(2);
        fibonacci(5);
        fibonacci(7);
        fibonacci(20);
        bloodNum();
    }

    private static void fibonacci(int size) {
        if (size == 1) {
            System.out.print(1);
        }
        if (size == 2) {
            System.out.print(1 + " " + 1);
        }
        if (size > 2) {
            System.out.print(1 + " " + 1);
            int x = 1;
            int y = 1;
            for (int i = 0; i < size; i++) {
                System.out.print(" " + (x + y));
                int temp = x;
                x = y;
                y += temp;
            }
        }
        System.out.println();
    }

    private static void bloodNum() {
        for (int i = 10; i < 100; i++) {
            for (int j = 10; j < 100; j++) {
                int temp = i * j;
                if (9999 > temp && temp > 999 && temp % 100 != 0) {
                    System.out.println(i + " * " + j + " = " + temp);
                }
            }
        }
    }

    private static int bloodNum(boolean r) {
        return 1;
    }

    private static int f() {
        return 1;
    }

    private static int f(int x) {
        return x;
    }

    private static int f(Integer x) {
        return x;
    }
}
