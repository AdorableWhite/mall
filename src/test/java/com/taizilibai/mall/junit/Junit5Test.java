package com.taizilibai.mall.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2021/1/22 10:11
 */
public class Junit5Test {
    @Test
    @DisplayName("测试断言equals")
    public void testAssertion() {
        try {
            Assertions.assertEquals(3, 4,"给定值不相等");
            System.out.println(1);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


    @Test
    @DisplayName("测试断言抛异常")
    public void testAssertThrows() {
        ArithmeticException arithmeticException = Assertions.assertThrows(ArithmeticException.class, () -> {
            int m = 5 / 0;
        });
        Assertions.assertEquals("/ by zero", arithmeticException.getMessage());
    }

    @Test
    @DisplayName("测试断言判空")
    public void testAssertNull() {
        Assertions.assertNull(new Object(), 1==2?"true":"false");
    }

    @Test
    @DisplayName("测试超时")
    public void testAssertTimeOut() {
        String s = Assertions.assertTimeout(Duration.ofSeconds(2), () -> {
            Thread.sleep(2000);
            return "a result";
        });
        System.out.println(s);
    }


    @Test
    @DisplayName("测试组合断言")
    public void testAssertAll() {
        Assertions.assertAll("测试商品下单",()->{
            // 模拟用户余额扣减
            Assertions.assertTrue(1<2, "余额不足");
        }, () -> {
            // 模拟商户扣减库存
            Assertions.assertTrue(3<4);
        }, () -> {
            // 模拟交易流水落库
            Assertions.assertNull(new Object(), "交易流水落库失败");
        });
    }


    @RepeatedTest(5)
    @Test
    public void testRepeatedTest() {
        System.out.println("调用");
        System.out.println("diaoyong");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    public void testPatameterized(int a) {
        Assertions.assertTrue(a<4);
    }

    @Test
    public void testInteger() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        int i=-123;
        System.out.println(i);
    }




}
