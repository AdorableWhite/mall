package com.taizilibai.mall.controller;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

import java.io.UnsupportedEncodingException;
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

    @Test
    public void testClone() {
        Object t1 = "zhangsan";
        System.out.println(t1.toString());
    }

    @Test
    public void testBFS() {
        // 将英文大写字符转为小写
        System.out.println('a' | ' ');
        System.out.println('A' & ' ');
        System.out.println('C' & ' ');
        String name = "AbCdEfghsdajHHSIAjoPqRstUvwxYzZ";
        byte[] bytes = name.getBytes();
        byte[] result = new byte[name.length()];
        for(int i=0; i< bytes.length; i++) {
            result[i] = (byte)(bytes[i] | ' ');
        }
//        System.out.println(new String(result, "utf-8"));
        System.out.println(new String(result));

        byte[] upperCase = new byte[bytes.length];
        for(int i=0; i<bytes.length; i++) {
            upperCase[i] = (byte)(bytes[i] & '_');
        }
        System.out.println(new String(upperCase));

    }
}
