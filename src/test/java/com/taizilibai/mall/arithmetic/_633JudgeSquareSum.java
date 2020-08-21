package com.taizilibai.mall.arithmetic;

/**
 * @Description: 633. 平方数之和
 * @Author: zxx
 * @Date: 2020/8/20 10:23
 */
public class _633JudgeSquareSum {

    public static boolean judgeSquareSum(int c) {
        int max = (int) Math.sqrt(c);
        int result;
        for(int i=0; i<=max; i++) {
            for(int j = max; j>=i; j--) {
                result = i*i +j*j;
                if(result < c) break;
                if(result > c) continue;
                if(result == c) return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        boolean b = judgeSquareSum(8);
        System.out.println(b);
    }
}

