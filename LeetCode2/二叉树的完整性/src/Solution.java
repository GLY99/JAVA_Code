import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode cur = queue.poll();
            if (cur == null){
                break;
            }
            if (cur.left != null){
                queue.offer(cur.left);
            }else{
                queue.offer(null);
            }
            if (cur.right != null){
                queue.offer(cur.right);
            }else{
                queue.offer(null);
            }
        }
        while (!queue.isEmpty()){
            if (queue.poll() == null){

            }else{
                return false;
            }
        }
        return true;
    }
}
