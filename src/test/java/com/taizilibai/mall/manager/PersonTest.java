package com.taizilibai.mall.manager;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.*;

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

    @Test
    public void testLinkedListSize() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);

        for (int i = 0; i < q.size(); i++) {
            System.out.println(q.size());
            q.poll();
        }
    }

    public static String minusOne(String str, int j) {
        char[] chars = str.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            chars[j] -= chars[j];
        }
        return new String(chars);
    }

    public static String plusOne(String str, int j) {
        char[] chars = str.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j] += chars[j];
        }
        return new String(chars);
    }

    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(deadends.length);
        for (String dead : deadends) {
            visited.add(dead);
        }

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");
        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String poll = q.poll();
                if (target.equals(poll)) {
                    return step;
                }
                if (visited.contains(poll)) continue;
                for (int j = 0; j < 4; j++) {
                    String plus = plusOne(poll, j);
                    if (!visited.contains(plus)) {
                        q.offer(plus);
                        visited.add(plus);
                    }

                    String minus = minusOne(poll, j);
                    if (!visited.contains(minus)) {
                        q.offer(minus);
                        visited.add(minus);
                    }
                }
            }
            step++;
        }


        return -1;
    }

    @Test
    public void testPaymentCode() {
        String paymentCode = "ALIPAYPC_";
        if (paymentCode.contains("_")) {
            paymentCode = paymentCode.substring(0, paymentCode.indexOf("_"));
        }
        System.out.println(paymentCode);
    }


    @Test
    public void testMapAdd() {

        Map<String, String> map = new HashMap<>();
        map.put("zhang", "san");
        map.put("zhang", map.getOrDefault("zhang", "0") + 1);
        System.out.println(map);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("zhang", 2);
        map2.put("zhang", map2.getOrDefault("zhang", 0) + 1);
        map2.getOrDefault("zhao", 4);
        map2.put("zhao", map2.getOrDefault("zhao", 0) + 1);
        System.out.println(map2);
    }

    /**
     * 转小写  char |=' ';
     * 转大写 char &= '_';
     * 大小写逆转 char ^=' ';
     */
    @Test
    public void testY() {
        String s = "zHaNSanKoiNIAHoinoiSAIODoijoIni";
        char[] result = new char[s.length()];
        int i = 0;
        for (char tmp : s.toCharArray()) {
            tmp ^= ' ';
            result[i++] = tmp;
        }
        System.out.println("reverse:" + new String(result));

        i = 0;
        for (char tmp : s.toCharArray()) {
            tmp &= '_';
            result[i++] = tmp;
        }
        System.out.println("toUpperCase:" + new String(result));


        i = 0;
        for (char tmp : s.toCharArray()) {
            tmp |= ' ';
            result[i++] = tmp;
        }
        System.out.println("toLowerCase:" + new String(result));
    }

    /**
     * 0 的两种情况
     */
    @Test
    public void testJudgeTwoNums() {
        int x = -0, y = 2, a = 0, b = -2;
        System.out.println((x^y)<0);
        System.out.println((a^b)<0);
    }

    @Test
    public void hammingWeight() {
        int n = 8;
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        System.out.println(res);
    }

    class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        public TreeNode() {}
        public TreeNode(int value) {
            this.val = value;
        }
        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.val = value;
            this.left = left;
            this.right = right;
        }
    }
    @Test
    public void traverse() {
        int[][] nums=new int[][]{{1,3},{1,2},{4,5},{3,7}};
        //方法一
        Arrays.sort(nums,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                if(a[0]==b[0]){
                    return a[1]-b[1];
                }else{
                    return a[0]-b[0];
                }
            }
        });


        // 方法二，使用匿名表达式
        // (a,b)->a[1]-b[1]会自动转变成上面的形式
//        Arrays.sort(nums,(a,b)->a[1]-b[1]);
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }

        int[] a={2,5,4,3,1,8};
        Arrays.sort(a,2,5);
        System.out.println(Arrays.toString(a));
    }


}
