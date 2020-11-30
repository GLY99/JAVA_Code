import java.util.Stack;
//二叉搜索树的中序是从小到大，那么它中序的逆序就是从大到小，根据这个进行遍历，遍历到第K个返回
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    int count = 0;
    int ret = -1;
    public int kthLargest(TreeNode root, int k) {
        helper(root,k);
        return ret;
    }
    public void helper(TreeNode root,int k){
        if (root == null)return;
        if (root.right != null){
            helper(root.right,k);
        }
        if (++count == k){
            ret = root.val;
            return;
        }
        if (root.left != null){
            helper(root.left,k);
        }
    }
    public int kthLargestI(TreeNode root,int k){
        int count = 0;
        int ret = -1;
        if (root == null)return ret;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.add(cur);
                cur = cur.right;
            }
            TreeNode top = stack.pop();
            count++;
            if (count == k){
                ret = top.val;
                return ret;
            }
            if (top.left != null){
                cur = top.left;
            }
        }
        return -1;
    }
    /*public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list.get(list.size() - k);
    }
    public void helper(TreeNode root,List<Integer> list){
        if (root == null)return;
        if (root.left != null) {
            helper(root.left, list);
        }
        list.add(root.val);
        if (root.right != null){
            helper(root.right,list);
        }
    }*/
}
