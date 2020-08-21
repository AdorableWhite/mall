package com.taizilibai.mall.manager;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import javax.annotation.Resource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2020/8/20 17:47
 */
class PersonTest {

    @Test
    public void testFunction() {

        Person person1 = new Person() {
            @Override
            public String say(String input) {
                System.out.println("say");
                return "a" + input;
            }
        };

        person1.eat();
        person1.say("adf");
    }


    @Test
    public void testDeepEquals() {

        boolean a = false;
        System.out.println("assert before");
        Assert.isTrue(a);
        System.out.println("assert after");

    }

}
