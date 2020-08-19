package com.taizilibai.mall.controller;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2020/8/19 11:29
 */
class RedisControllerTest {


    @Test
    void setUser() {
        System.out.println("asdf");

    }

    public static String printStr(String str) {
        System.out.println("print:" + str);
        return str;
    }

    @Test
    public void testDoubleQuotes(){
        List<String> al = Arrays.asList("a","b","c","d");
        al.forEach(RedisControllerTest::printStr);
        Consumer<String> consumer = RedisControllerTest::printStr;
        ListIterator<String> stringListIterator = al.listIterator();

    }

}
