package Y2020M4;

public class demo116 {
    /*

    ArrayDeque的
poll方法：出队，队空返回空
peek方法：取对头元素，不删除，队空返回空。

pop：出队，队空异常
element：取队头，队空异常

1. 层次遍历
public Node connect(Node root) {
        if(root == null) return null;
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node visit = queue.poll();

                //当是最后一个元素时，指向空
                if( i != size-1){
                    visit.next = queue.peek();
                }else{
                    visit.next = null;
                }
                if(visit.left != null) queue.add(visit.left);
                if(visit.right != null) queue.add(visit.right);
            }
        }
        return root;

    }



 2. 递归：
  此方法中，没有对 root.next= null 进行赋值，因为Class里面的引用类型的成员变量没赋值情况下默认就是null
class Solution {
    public Node connect(Node root) {
        // 结束条件
        if(root == null || root.left == null)
            return root;
         //  处理树的左孩子和右孩子的next节点
        root.left.next = root.right;
        if(root.next != null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
     */
}
