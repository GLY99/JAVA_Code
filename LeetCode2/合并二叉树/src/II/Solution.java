package II;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)return null;
        if (t1 == null)return t2;
        if (t2 == null)return t1;
        int value = t1.val + t2.val;
        TreeNode root = new TreeNode(value);
        root.left = mergeTrees(t1.left,t2.left);
        root.right = mergeTrees(t1.right,t2.right);
        return root;
    }
}
