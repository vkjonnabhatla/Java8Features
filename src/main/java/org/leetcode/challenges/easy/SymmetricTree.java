package org.leetcode.challenges.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * Follow up: Solve it both recursively and iteratively.
 */
public class SymmetricTree {
    public static int max = 0;
    public static int res = 0;
    public static int res_min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);*/
        //System.out.println(isMirror(root, root));
        //System.out.println(isMirrorIteratively(root));

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        //root.left.right = new TreeNode(4);
        //root.right.left = new TreeNode(4);
        //root.right.right = new TreeNode(3);


        //maxDepth(root, 0);
        System.out.println(minDepth(root));
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public static boolean isMirrorIteratively(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if(t1 == null && t2 == null) continue;
            else if(t1 == null || t2 == null) return false;

            if(t1.val != t2.val) return false;

            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
      return true;
    }

    public static void maxDepth(TreeNode root, int max){
        if(root == null) return;
        max++;
        maxDepth(root.left, max);
        res = Math.max(res, max);
        maxDepth(root.right, max);
    }

    public static int minDepth(TreeNode root){
        if(root == null) return 0;

        if(root.left == null && root.right == null){
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;

        if(root.left != null){
            min_depth = Math.min(minDepth(root.left), min_depth);
        }

        if(root.right != null){
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }
}
