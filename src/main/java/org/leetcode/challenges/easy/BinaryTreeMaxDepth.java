package org.leetcode.challenges.easy;

import java.util.LinkedList;

public class BinaryTreeMaxDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root){
        LinkedList<Pair> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        if (root == null) return 0;

        stack.add(new Pair(root, 1));
        depths.add(1);

        int depth = 0, current_depth = 0;
        while(!stack.isEmpty()) {
            Pair pair = stack.pollLast();
            TreeNode current = pair.root;
            current_depth = pair.count;
            depth = Math.max(depth, current_depth);

            if(current.left != null){
                stack.add(new Pair(current.left, current_depth + 1));
            }

            if(current.right != null){
                stack.add(new Pair(current.right, current_depth + 1));
            }


        }
        return depth;
    }
}
