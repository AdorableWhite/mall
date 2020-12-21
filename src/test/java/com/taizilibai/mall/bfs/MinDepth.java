package com.taizilibai.mall.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:111. 二叉树的最小深度
 * @Date: 2020/12/15 11:25
 */
public class MinDepth {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int dept = 1;

        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                TreeNode poll = q.poll();
                if (poll.left == null && poll.right == null) {
                    return dept;
                }

                if (poll.left != null) {
                    q.offer(poll.left);
                }
                if (poll.right != null) {
                    q.offer(poll.right);
                }
                dept ++;
            }
        }
        return dept;
    }

}
