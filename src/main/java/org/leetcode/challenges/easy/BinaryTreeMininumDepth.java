package org.leetcode.challenges.easy;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMininumDepth {

    public static void main(String[] args) {

    }

    public static int minDepth(TreeNode root){
        Queue<Pair> queue =  new LinkedList<>();
        if(root == null){
            return 0;
        }else{
            queue.add(new Pair(root, 1));
        }
        int min_depth = 0;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            TreeNode t1 = pair.root;
            min_depth = pair.count;
            if(root.left != null && root.right != null){
                break;
            }
            if(root.left != null){
                queue.add(new Pair(root.left, min_depth + 1));
            }

            if(root.right != null){
                queue.add(new Pair(root.right, min_depth + 1));
            }
        }
        return min_depth;
    }




}

class Pair{
    public TreeNode root;
    public Integer count;
    public Pair(TreeNode root, Integer count){
        this.root = root;
        this.count = count;
    }
}
