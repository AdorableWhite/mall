package com.taizilibai.mall.binarytree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2021/1/22 11:21
 */
@DisplayName("二叉树测试")
class BinaryTreeTest {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);

        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    TreeNode buildTree(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
        TreeNode node = new TreeNode(preOrder[preLeft]);
        int index = -1;
        for(int i = inLeft; i <= inRight; i++) {
            if (inOrder[i] == preOrder[preLeft]) {
                index = i;
                break;
            }
        }

        node.left = buildTree(preOrder, preLeft+1, preLeft + index - inLeft , inOrder, inLeft, index-1);
        node.right = buildTree(preOrder, preLeft+index-inLeft+1, preRight, inOrder, index+1, inRight);
        return node;
    }


    @Test
    @DisplayName("根据前序中序遍历构造二叉树")
    public void testConstructBinaryTree() {

    }

    public TreeNode build(int[] inorder, int inleft, int inright, int[] postorder, int postleft, int postright) {

        if(inleft > inright) {
            return null;
        }

        int index = -1;
        for(int i=inleft; i<=inright; i++) {
            if(postorder[postright] == inorder[i]) {
                index = i;
                break;
            }
        }

        TreeNode node = new TreeNode(postorder[postright]);
        node.left = build(inorder, inleft, index-1, postorder, postleft, postleft+index-inleft);
        node.right = build(inorder, index+1, inright, postorder, postleft+index-inleft+1, postright-1);

        return node;
    }





    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return result;
    }
    List<TreeNode>  result = new ArrayList<>(16);
    HashMap<String, Integer> subTree = new HashMap<>(16);
    //
    public String traverse(TreeNode root) {
        if(root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String str = left + "," + right + "," + root.val;

        Integer number = subTree.getOrDefault(str, 0);
        if(number == 1) {
            result.add(root);
        }
        subTree.put(str, number+1);


        return str;
    }


    @Test
    @DisplayName("测试字符串")
    public void testStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();

        String data = new String("");
        String[] split = data.split(",");

        int res= (int) Math.pow(2, 3) -1;
        System.out.println(res);

    }


    @Test
    @DisplayName("测试多线程")
    public void testDThread() {
        System.out.println("main thread start");
        Thread t = new MyThread();
        t.start();

        try {
            Thread.sleep(1000);
            t.interrupt();
            t.join();
            System.out.println("main end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }


    class MyThread extends Thread {
        @Override
        public void run() {
            HelloThread helloThread = new HelloThread();
            helloThread.start();
            try {
                helloThread.join();
            } catch (InterruptedException e) {
                System.out.println("Mythread HelloThread interrupted");
            }

            helloThread.interrupt();
        }
    }

    class HelloThread extends Thread {
        @Override
        public void run() {
            int n = 0;
            while (!isInterrupted() && n <= 100) {
                System.out.println(n++);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("helloThread interrupted");
                    break;
                }
            }
        }
    }



    class MarkThread extends Thread {
        public volatile boolean running = true;

        @Override
        public void run() {
            int n = 0;
            while (running) {
                System.out.println(n);
            }
            System.out.println("end!");
        }
    }

    @Test
    @DisplayName("测试标识位打断线程")
    public void testVolatile() {
        MarkThread markThread = new MarkThread();
        markThread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        markThread.running = false;
    }


}
