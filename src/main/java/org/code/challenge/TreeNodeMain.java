package org.code.challenge;


public class TreeNodeMain {

	public static void main(String[] args) {
        TreeNode binaryTree = new TreeNode(1);
        TreeNode leftChild = new TreeNode(2);
        TreeNode rightChild =  new TreeNode(5);
        binaryTree.setLeft(leftChild);
        binaryTree.setRight(rightChild);
        
        TreeNode leftNodeThree = new TreeNode(3);
        TreeNode rightNodeFour =  new TreeNode(4);
        
        
        leftChild.setLeft(leftNodeThree);
        leftChild.setRight(rightNodeFour);
        
        TreeNode rightNodeSix = new TreeNode(6);
        rightChild.setRight(rightNodeSix);
        
        TreeNode flattenTree = flattenBinaryTree(binaryTree);
        System.out.println(flattenTree);
        
	}
	
	public static TreeNode flattenBinaryTree(TreeNode tree) {
		TreeNode current = null; 
		if(tree != null) {
			flattenBinaryTree(tree.getLeft());
			flattenBinaryTree(tree.getRight());
			
			if(tree.getLeft() != null) {
				current = tree.getLeft();
				while(current.getRight() != null) {
					current = current.getRight();
				}
				current.setRight(tree.getRight());
				tree.setRight(tree.getLeft());
				tree.setLeft(null);
			}
		}
		return tree;
	}
}
