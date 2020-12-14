import java.util.Stack;

//将二叉树转成单向链表
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
//递归法
public class Solution {
    TreeNode prev;
    TreeNode head;
    public TreeNode convertBiNode(TreeNode root) {
        if (root == null)return null;
        dfs(root);
        return head;
    }
    public void dfs(TreeNode cur){
        if (cur == null)return;
        dfs(cur.left);
        if (prev != null){
            prev.right = cur;
        }else {
            head = cur;
        }
        cur.left = null;
        prev = cur;
        dfs(cur.right);
    }
}
//迭代法
class SolutionI {
    public TreeNode convertBiNode(TreeNode root) {
        if (root == null)return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = null;
        TreeNode prev = null;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.add(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            if (prev != null){
                prev.right = top;
            }else {
                head = top;
            }
            top.left = null;
            prev = top;
            if (top.right != null){
                cur = top.right;
            }
        }
        return head;
    }
}
