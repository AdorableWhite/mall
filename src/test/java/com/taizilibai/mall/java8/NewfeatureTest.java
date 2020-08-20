package com.taizilibai.mall.java8;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2020/8/20 11:00
 */
public class NewfeatureTest {

    public static String setObject(Object obj) {

        if(obj instanceof String) {

        }
        return obj.toString();
    }

    public static String setObjectList(Object[] objects) {
        if(objects instanceof Integer[]) {

        }
        return Arrays.toString(objects);
    }

    public static String setObjectThreePoint(Object... obj) {

        if(obj instanceof Integer[]) {
            return Arrays.toString(obj);
        }
        return Arrays.toString(obj);

    }

    @Test
    public void testObject() {
        System.out.println(setObject("abc"));
        Integer[] ints = {1,2,3,4,5,6};
        System.out.println(setObjectList(ints));

        System.out.println(setObjectThreePoint("abc"));
        System.out.println(setObjectThreePoint(ints,"abc"));






    }
}
