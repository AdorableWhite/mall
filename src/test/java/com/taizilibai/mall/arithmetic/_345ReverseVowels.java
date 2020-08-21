package com.taizilibai.mall.arithmetic;


import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @Description: 反转字符串中的元音字母
 * @Author: zxx
 * @Date: 2020/8/20 17:06
 */
public class _345ReverseVowels {



    public static String reverseVowels(String s) {
        if(s == null || s.length()==0) {
            return "";
        }

        char[] result = new char[s.length()];
        int i=0;
        int j=s.length()-1;
        while(i <= j) {
            if(!vowels.contains(s.charAt(i))) {
                result[i++] = s.charAt(i);
            } else if(!vowels.contains(s.charAt(j))) {
                result[j--] = s.charAt(j);
            } else {
                result[i] = s.charAt(j);
                result[j] = s.charAt(i);
                i++;
                j--;
            }
        }


        char[] response = s.toCharArray();
        int a = 0;
        int b = s.length() - 1;
        while(a < b) {
            if(!vowels.contains(s.charAt(a))) {
                
            }

        }


        /*int a = 0;
        int b = s.length() -1;
        char[] result = s.toCharArray();
        while(a < b) {
            if(!vowels.contains(result[a])) {
                a++;
            } else if(!vowels.contains(result[b])) {
                b--;
            } else {
                char tmp = result[a];
                result[a++] = result[b];
                result[b--] = tmp;
            }

        }*/

        /*int i = 0;
        int j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(!vowels.contains(ci)) {
                result[i++] = ci;
            } else if(!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }*/


        /*char[] result = s.toCharArray();
        for(int i=0; i<s.length(); i++) {
            for(int j=s.length()-1; j>i; j--) {
                if(vowels.contains(s.charAt(j))) {
                    if(!vowels.contains(s.charAt(i))) {
                        break;
                    }
                    result[i] = s.charAt(j);
                    result[j] = s.charAt(i);
                }
            }
        }*/
        return new String(result);
    }

    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

    public static void main(String[] args) {
        String aeiou = reverseVowels("hello");
        System.out.println(aeiou);
    }
}
