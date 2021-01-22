
package com.taizilibai.mall.stream;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2020/12/30 11:38
 */
public class StreamTest {
    @Test
    public void testStreamList() {
        List<String> strings = Arrays.asList("a", "bb", "cc", "aa", "bb", "dd", "cc");
        List<String> result = new ArrayList<>();
        Map<String, Long> collect = strings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.forEach((k,v)->{
            if(v>1) {
                result.add(k);
            }
        });
        System.out.println(result.toString());
    }


    @Test
    public void testNullString() {
        String str = "     aa   ";
        int length = str.length();
        for(int i = 0; i < length; i++){
            char c = str.charAt(i);
            char a = ' ';
            System.out.println(a^c);
        }
    }

    @Test
    public void testRandom() {
        Random random = new Random(10);
        random.ints().limit(10).forEach(System.out::println);
    }

    @Test
    public void testMap() {
        List<Float> numbers = Arrays.asList(2f,1f,3f,4f,1f,2.3f);
        List<Float> collect = numbers.stream().map(i -> i * i).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);


        List<String> stringList = Arrays.asList("asd", "asdf", "sadfa", "sadfw");
        List<Character> collect1 = stringList.stream().map(str -> str.charAt(2)).collect(Collectors.toList());
        collect1.stream().forEach(System.out::println);

    }


    @Test
    public void testJoin() {
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);
    }


    @Test
    public void testMaptoInt() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static void flatten(TreeNode root) {
        if(root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode tmp = root;
        while(tmp.right != null) {
            tmp = tmp.right;
        }
        tmp.right = right;
    }

    @Test
    public void testFlattenTreeNode() {
        List<Integer> integers = Arrays.asList(1, 2, 5, 3, 4, null, 6);
        TreeNode root = new TreeNode();
        for(int i=0; i<integers.size(); i++) {

        }
    }

    static public int fib(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }

        int[] dict = new int[n];
        dict[0] = dict[1] = 1;
        for(int i = 2; i < n; i++) {
            dict[i] = dict[i-1] + dict[i-2];
        }
        return dict[n-1];
    }



    @Test
    public void testFib() {
        System.out.println(fib(8));
        Vector<Integer> integers = new Vector<>(3, 3);
        System.out.println(integers);
    }


    @Test
    public void slidingWindow() {
        String s = "", t = "";
        Map<Character, Integer> need = null, window = null;
        int i = 0;
        for(char c : t.toCharArray()) {
            need.put(c, i++);
        }
        int right = 0, left = 0;
    }

    private TreeNode findMaxValue(int nums[], int left, int right) {

        int max = Integer.MAX_VALUE;
        int index = -1;
        for(int i = left; i < right; i++) {
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        TreeNode node = new TreeNode(max);
        node.left = findMaxValue(nums, left, index);
        node.right = findMaxValue(nums, index+1, right);

        return node;
    }
}
