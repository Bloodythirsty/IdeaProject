//import java.util.ArrayDeque;
//
//public class _114二叉树展开链表 {
//    public static void main(String[] args) {
//
//    }
//
//    public void flatten(TreeNode root) {
//        if(root == null) return ;
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        TreeNode p = new TreeNode(0);
//        while(root != null || !stack.isEmpty()){
//            while(root != null){
//                p.right = root;
//                p.left = null;
//                p = p.right;
//                if(root.right != null){
//                    stack.push(root.right);
//                }
//                root = root.left;
//            }
//            root = stack.pop();
//            // root = root.right;
//        }
//    }
//}
