package com.taizilibai.mall.manager;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2020/8/20 17:44
 */
@FunctionalInterface
public interface Person {
    String say(String input);
    static void walk(String str) {
        System.out.println("walk");
    }
    static void run(String str) {
        System.out.println("run");
    }
    default void eat() {
        System.out.println("eat");
    }

    default void drink() {
        System.out.println("drink");
    }
}
