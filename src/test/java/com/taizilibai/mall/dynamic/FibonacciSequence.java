package com.taizilibai.mall.dynamic;
package com.taizilibai.mall.dynamic;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2020/12/9 16:07
 */
public class FibonacciSequence {

    /**
     * 直接穷举
     * @param i
     * @return
     */
    // 输入一个数，获取该数对应的斐波那契数列的值 recursive all
    public static int fibonacci1(int i) {
        if(i < 0 || i > Integer.MAX_VALUE) {
            return 0;
        }
        if(i == 1 || i == 2) {
             return 1;
        }
        return fibonacci1(i-1) + fibonacci1(i-2);
    }

    /**
     *  设置备忘录穷举，自顶向下
     * @param index
     * @return
     */
    public static int fibonacci2(int index) {
        if(index <0 || index> Integer.MAX_VALUE) {
            return 0;
        }
        Vector<Integer> dp = new Vector<>(index + 1, 0);
        for(int i = 0; i <= index; i++) {
            dp.add(0);
        }
        return helper(dp, index);
    }

    public static int helper(Vector<Integer> dp, int index) {
        if(index <0 || index> Integer.MAX_VALUE) {
            return 0;
        }
        if(index == 1 || index == 2) {
            return 1;
        }
        if(dp.get(index) != 0) {
            return dp.get(index);
        }
        int tmp = helper(dp, index-1) + helper(dp, index-2);
        dp.set(index, tmp);
        return tmp;
    }

    /**
     * 自底向上
     * @return
     */
    public static int fibonacci3(int index) {
        if(index < 0 || index > Integer.MAX_VALUE) {
            return 0;
        }
        if(index ==1 || index == 2) {
            return 1;
        }

        LinkedList<Integer> base = new LinkedList<>();
        base.add(0,0);
        base.add(1, 1);
        base.add(2,1);
        for(int i = 3; i <= index; i++) {
            base.add(i, base.get(i-1) + base.get(i-2));
        }
        return base.get(index);
    }

    public static void main(String[] args) {
//        System.out.println(fibonacci1(6));
//        System.out.println(fibonacci2(6));
        System.out.println(fibonacci3(20));
    }

    @Test
    public void testVector() {
        Vector<Integer> memo = new Vector<>(5+1, 0);
        for(Integer tmp : memo) {
            System.out.println(tmp);
        }
        memo.add(1);
        memo.add(3);
        for(Integer tmp : memo) {
            System.out.println(tmp);
        }
    }

    @Test
    public void testLinkedHashSet() {
        Set<Integer> base = new LinkedHashSet<>(5,1);
        for(Integer tmp : base) {
            System.out.println(tmp);
        }
    }


}
