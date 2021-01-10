//给出二叉 搜索 树的根节点，该树的节点值各不相同，
// 请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
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
    //进行二叉搜索树的中序的逆序遍历
    private int prev = 0;//存储大值的和
    public TreeNode bstToGst(TreeNode root) {
        if (root == null)return null;
        bstToGst(root.right);//向右遍历
        if (prev == 0){
            prev = root.val;//第一次
        }else {
            prev += root.val;
        }
        root.val = prev;
        bstToGst(root.left);
        return root;
    }
}
