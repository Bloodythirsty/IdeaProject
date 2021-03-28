package tree;

import org.junit.Test;

/*

        建立二叉平衡树
 */
public class TreeTest {


    public static void main(String[] args) {
        Integer[] res = {1,2,null,4,5};
        Tree tree = new Tree();
        for (Integer re : res) {
            if (re!=null) tree.add(re);
        }
    }

}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}

class Tree{
    TreeNode root = null;

    //简单树，假设没有重复节点
    public void add(Integer e){
        TreeNode t = root;
        if (t==null){
            root = new TreeNode(e);
        }else {
            TreeNode parent = findParent(e);
            if (parent.val > e) parent.left = new TreeNode(e);
            else parent.right = new TreeNode(e);
        }

    }

    //找到要插入节点的父节点
    public TreeNode findParent(int e){
        TreeNode parent = root;
        TreeNode pp = null;
        while(parent!=null){
            pp = parent;
            if(parent.val > e){
                parent = parent.left;
            }else {
                parent = parent.right;
            }
        }
        return pp;
    }
}

