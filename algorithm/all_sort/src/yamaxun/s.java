// public class Iterator{
//
//     Deque<TreeNode> deque;
//     TreeNode curr;
//
//
//     public Iterator(TreeNode root){
//         deque = new ArrayDeque<>();
//         dfs(root);
//
//     }
//
//     private void dfs(TreeNode root){
//         curr = root;
//         if(root != null && root.left != null){
//             deque.push(root);
//             dfs(root.left);
//         }
//     }
//
//     public Object next(){
//         if(curr == null) return null;
//         return curr.val;
//     }
//
//     public boolean hasNext(){
//         if(curr == null) return false;
//         if(curr.right!=null){
//             dfs(curr.right);
//             return true;
//         }else if( curr.right == null && !queue.isEmpty()){
//             curr = queue.pop();
//         }
//     }
// }