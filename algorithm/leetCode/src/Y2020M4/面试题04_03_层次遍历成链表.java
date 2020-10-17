package Y2020M4;

public class 面试题04_03_层次遍历成链表 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*

1.  定义一个结构，里面存了树的层次，但这样无法确定ListNode的大小

class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {

        ListNode[] listNode = new ListNode[20];


        ArrayDeque<BT> queue = new ArrayDeque<>();
        TreeNode p = tree;
        BT bt = new BT(p,1);
        queue.add(bt);
        while(!queue.isEmpty()){
            BT visited =  queue.poll();

            //拜访节点
            add(listNode[visited.level], visited.tn);

            if(visited.tn.left != null){
                queue.add(new BT(visited.tn.left,visited.level+1)) ;
            }

            if(visited.tn.right != null){
                queue.add(new BT(visited.tn.right,visited.level+1)) ;
            }

        }

        return listNode;
    }

    public void add(ListNode list, TreeNode tn){
        if(list == null)  return ;

        ListNode p = list;
        while( p.next != null){
            p = p.next;
        }
        p.next = new ListNode(tn.val);
    }

    private class BT{
        TreeNode tn;
        int level;
        BT(TreeNode tn , int level){
            this.tn = tn;
            this.level = level;
        }
    }
}

 */


/*

2. 其实每层刚好遍历完时，队列中的节点刚好是全部的下一层节点
    所以while循环内，再利用queue的size，进行一次遍历，这次遍历就是同一层的遍历

public ListNode[] listOfDepth(TreeNode tree) {
        //空树，直接返回空数组
        if(tree == null){
            return new ListNode[0];
        }
        // 队列，层次遍历二叉树
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(tree);
        // 数组，存每一层的链表头
        List<ListNode> list = new ArrayList<>();
        //重复用的链表头
        ListNode head = new ListNode(-1);
        while(!queue.isEmpty()){
            ListNode curr = head;
            //每一层的大小
            int size = queue.size();
            //按照每一层开始遍历
            for(int i = 0; i< size; i++){
                TreeNode visit = queue.poll();
                curr.next = new ListNode(visit.val);
                curr = curr.next;
                //左右子树放进队列
                if(visit.left != null) queue.add(visit.left);
                if(visit.right != null) queue.add(visit.right);
            }
            //每层链表的头节点放入List，最后放进最终的List返回（确保精确的数组个数）
            list.add(head.next);
        }

        //最终放入List返回
        ListNode[] nodes = new ListNode[list.size()];
        for(int i = 0 ; i < list.size() ; i++)
            nodes[i] =  list.get(i);
        return nodes;

    }

 */
}
