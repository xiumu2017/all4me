package com.paradise.think.enum19;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Paradise
 */
enum Explore {
    /**
     * 这儿
     */
    HERE,
    /**
     * 那儿
     */
    THERE
}

/**
 * @author Paradise
 */
public class Reflection {

    private static Set<String> analyze(Class<?> enumClass) {
        System.out.println("--- Analyzing " + enumClass + "---");
        System.out.println("Interfaces: ");
        for (Type type : enumClass.getGenericInterfaces()) {
            System.out.println(type);
        }
        System.out.println("Base: " + enumClass.getSuperclass());

        System.out.println("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method method : enumClass.getMethods()) {
            methods.add(method.getName());
        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);

        System.out.println("contains all ?");
        System.out.println(exploreMethods.containsAll(enumMethods));

        exploreMethods.removeAll(enumMethods);
        System.out.println(exploreMethods);
    }

}
