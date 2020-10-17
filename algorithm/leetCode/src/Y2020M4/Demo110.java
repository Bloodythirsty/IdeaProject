package Y2020M4;

import java.util.ArrayList;
import java.util.List;

/*
        判断二叉树是否为平衡二叉树
 */
public class Demo110 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    /*

    递归：
    1. 结束信息
    2. 一般处理
    3. 返回值

    class Solution {
        public boolean isBalanced(TreeNode root) {
            return height(root) >= 0;
        }

        private int height(TreeNode root){
            if(root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);

            if(lh >= 0 && rh >= 0 && Math.abs(lh - rh) <= 1){
                return Math.max(lh,rh) + 1;
            }else{
                return -1;
            }
        }
    }

     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("list.toString() = " + list.toString());
        list.remove(2);
        System.out.println("list.toString() = " + list.toString());

    }

}
