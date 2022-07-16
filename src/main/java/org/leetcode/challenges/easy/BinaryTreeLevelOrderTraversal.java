package org.leetcode.challenges.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> values = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        binaryTreeLevelOrderTraversal(root);
    }

    public static void binaryTreeLevelOrderTraversal(TreeNode root){
        if(root == null) return;
        helper(root, 0);
        Collections.reverse(values);
    }

    //
    public static void helper(TreeNode root, int level){
        if(root == null) return;
        if(values.size() == level){
            values.add(new ArrayList<>());
        }

        values.get(level).add(root.val);
        helper(root, level + 1);
        helper(root, level + 1);
    }

    // Approach 2 : BFS approach with taking two queues

    public static void binaryTreeLevelOrderTraversal_BFSApproach2(TreeNode root){
        if(root == null) return;
        List<List<Integer>> values = new ArrayList<>();
        ArrayDeque<TreeNode> current_level = new ArrayDeque<>();
        ArrayDeque<TreeNode> next_level = new ArrayDeque<>();
        next_level.add(root);
        while(!next_level.isEmpty()){
            current_level = next_level.clone();
            next_level.clear();
            values.add(new ArrayList<>());

            for(TreeNode node : current_level){

                values.get(values.size() - 1).add(node.val);

                if(node.left != null){
                    next_level.add(node.left);
                }

                if(root.right != null){
                    next_level.add(node.right);
                }
            }
        }
     }

}
