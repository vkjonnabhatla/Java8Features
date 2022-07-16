package org.leetcode.challenges.easy;

import java.util.*;

public class ValidateBinarySearchTree {

    public Integer prev = null;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        isValidBST(root);
    }

    public static boolean isValidBST(TreeNode root) {

        if(root == null){
            return false;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() > 0){
            TreeNode treeNode = queue.pop();
            if(treeNode.left != null && treeNode.val <= treeNode.left.val){
                return false;
            }

            if(treeNode.right != null && treeNode.val >= treeNode.right.val){
                return false;
            }
            if(treeNode.left != null) queue.offer(treeNode.left);
            if(treeNode.right != null) queue.offer(treeNode.right);
        }
        Stack<List<Integer>> stack = new Stack();
        Queue queue1 = new LinkedList();
        //queue1.p
        stack.add(Arrays.asList(root.val, root.val));
       // stack.p
        return true;
    }
    // Simple recursion
    public boolean dfs(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }

        if((min != null && root.val <= min) || (max != null && root.val >= max)){
            return false;
        }

        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }

    public boolean inorder(TreeNode root){
       if(root == null) return true;
       if(!inorder(root.left)) return false;
       if(prev != null && root.val <= prev) return false;
       return inorder(root.right);
    }
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
