package I;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode newhead = new TreeNode(-1);
        cur = newhead;
        increaseingBSTChild(root);
        return newhead.right;
    }
    public void increaseingBSTChild(TreeNode root){
        if (root == null)return;
        increaseingBSTChild(root.left);
        root.left = null;
        cur.right = root;
        cur = root;
        increaseingBSTChild(root.right);
    }
}
