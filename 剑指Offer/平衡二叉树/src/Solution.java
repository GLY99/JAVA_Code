//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
//遍历每个结点，判断每个结点的左右子树深度是否超过1
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)return true;
        if (Math.abs((height(root.left) - height(root.right))) > 1)return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    //树的高度为左右子树高度最大值加1
    public int height(TreeNode root){
        if (root == null)return 0;
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        return Math.max(leftheight,rightheight) + 1;
    }
}
