//求二叉树深度（二叉树深度等于左右子树深度最大值+1）
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)return 0;
        int leftdepth = maxDepth(root.left);
        int rightdepth = maxDepth(root.right);
        return Math.max(leftdepth,rightdepth) + 1;
    }
}
