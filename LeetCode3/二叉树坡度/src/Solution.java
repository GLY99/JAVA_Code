//给定一个二叉树，计算 整个树 的坡度 。
//一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。
// 如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
//整个树 的坡度就是其所有节点的坡度之和。
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    public int findTilt(TreeNode root) {
        int ret = 0;
        if (root == null)return ret;
        return Math.abs(sum(root.left) - sum(root.right)) + findTilt(root.left) + findTilt(root.right);
    }
    public int sum(TreeNode node){
        if (node == null)return 0;
        return sum(node.left) + sum(node.right) + node.val;
    }
}
