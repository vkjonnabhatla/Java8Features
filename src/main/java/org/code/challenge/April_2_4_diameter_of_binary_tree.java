package org.code.challenge;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class April_2_4_diameter_of_binary_tree {

    public static void main(String[] args) {
        April_2_4_diameter_of_binary_tree obj = new April_2_4_diameter_of_binary_tree();
        TreeNode rootNode = new TreeNode(1);
        rootNode.setLeft(new TreeNode(2));
        //rootNode.setRight(new TreeNode(3));
        System.out.println(obj.height(rootNode));
        System.out.println(obj.diameterOfBinaryTree(rootNode));
    }

    public int diameterOfBinaryTree(TreeNode node){
        if(node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        int leftDiameter = diameterOfBinaryTree(node.left);
        int rightDiameter = diameterOfBinaryTree(node.right);
        return Math.max(left + right, Math.max(leftDiameter, rightDiameter));
    }

    public int height(TreeNode node){
        if(node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}

