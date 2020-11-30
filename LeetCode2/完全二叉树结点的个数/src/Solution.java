import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)return 0;
        int leftcount = countNodes(root.left);
        int rightcount = countNodes(root.right);
        return leftcount + rightcount + 1;
    }
    public int countNodesI(TreeNode root){
        int count = 0;
        if (root == null)return count;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while (cur != null){
                count++;
                stack.add(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            if (top.right != null){
                cur = top.right;
            }
        }
        return count;
    }
    public int countNodesII(TreeNode root){
        int count = 0;
        if (root == null)return count;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            count++;
            if (tmp.left != null){
                queue.offer(tmp.left);
            }
            if (tmp.right != null){
                queue.offer(tmp.right);
            }
        }
        return count;
    }
}