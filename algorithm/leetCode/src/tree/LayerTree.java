package tree;

import org.junit.Test;

import java.util.ArrayDeque;

public class LayerTree {
    /*
            按层建立二叉树
                ：遍历数组，把建立好的节点放入队列，每次取出一个作为父节点
     */

    public static void main(String[] args) {
        Integer[] a = {1,2,null,4,5,null,null,8};
        TreeNode root = layerBuildTree(a);
        rightNode(root);
    }

    public static TreeNode layerBuildTree(Integer[] a){
        TreeNode root = new TreeNode(a[0]);
        //层次建立需要队列
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int i=1;
        while (i<a.length){
            TreeNode currentParent = queue.pollFirst();
            Integer value = a[i++];
            if(value!=null){
                TreeNode leftChild = new TreeNode(value);
                currentParent.left = leftChild;
                queue.addLast(leftChild);
            }
            if (i>=a.length) break;     //插入奇数个有问题
            value = a[i++];
            if (value!=null){
                TreeNode rightChile = new TreeNode(value);
                currentParent.right = rightChile;
                queue.addLast(rightChile);
            }
        }
        return root;
    }

    /*
            寻找公共父节点//递归
            //t1,t2 假设都存在~

            要是t1,t2有不存在的情况，其实最终都递归到根节点
            即根节点左右两边一个为空~是不是？？？？
            错误！要是t1,t2都在左子树上，右树也为null,也不能判断
            所以换种思路：要是t1,t2在树中不存在，则直接返回null
            所以，要是有以上需求，则先去树种寻找
     */
    public TreeNode findCommonParent(TreeNode root,int t1, int t2){
        //找到返回本身，没找到返回null
        if (root == null || root.val == t1 || root.val == t2){
            return root;
        }
        //看左右子树的情况
        TreeNode left = findCommonParent(root.left,t1,t2);
        TreeNode right  = findCommonParent(root.right,t1,t2);
        //包含t1,t2在一个子树上
        if (left == null) return right;
        if (right == null) return left;
        // t1,t2在两个子树上
        return root;

    }

    /*
            存不存在
            因为根据层次建树，所以只能用层次遍历查找，
            因为由数组建的树，好像只看数组存不存在就行，好像也没意义。。。
     */
    public boolean exists(TreeNode root,int target){
        return false;
    }

    @Test
    public void testFindCommonParent(){
        Integer[] a = {1,2,3,4,5,null,6,7,9,10,11};
        TreeNode root = layerBuildTree(a);
        TreeNode commonParent = findCommonParent(root, 4, 6);
        System.out.println("commonParent.val = " + commonParent.val);
    }

    /*
            打印树的右视图
     */
    public static void rightNode(TreeNode root){
        if (root ==null) return ;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            TreeNode p = null;
            for(int i=0; i<size;i++){
                p = deque.pollFirst();
                if (p.left != null) deque.addLast(p.left);
                if (p.right != null) deque.addLast(p.right);
            }
            //最后一个节点
            System.out.println(p.val);
        }

    }

    /*
            第二种办法：
            层次插入后，每层元素个数与层数有关系：
            0层：下标 0         1个
            1层：下标 1-2       2个
            2层：下标 3-6       4个
            3层：下标 7-14      8个
            四层：下标 15-30     16个
            即找每层最右边不为null的Integer即可

            1(1-2^h)/(1-2) = 2^h - 1 = n
     */
    public void reightNode_2(Integer[] a){
        int layerLow = 0;
        int layerHigh = 0;
        int layer = 0;
        for (;;layer++){
            layerLow = (1<<layer) - 1 ;
            layerHigh = (1<<(layer+1)) - 1 - 1 ;
            if (layerLow >= a.length) break;
            if (layerHigh >= a.length) layerHigh = a.length-1;
            //输出最右边数,肯定存在~，假设给的数组正确
            while (true){
                if (a[layerHigh]!=null){
                    System.out.println(a[layerHigh]);
                    break;
                }
                layerHigh--;
            }
        }

    }

    @Test
    public void test2(){
        Integer[] a = {1,2,null,4,5,null,null,8,9};
        reightNode_2(a);
    }

    @Test
    public void testWEIyunSuan(){
        System.out.println(1<<(0));
    }

}
