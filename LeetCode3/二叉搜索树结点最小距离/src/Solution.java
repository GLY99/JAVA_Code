//给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode prev = null;//记录前一个结点
    public int ret = Integer.MAX_VALUE;//记录最小值
    public int minDiffInBST(TreeNode root) {
        if (root == null)return 0;
        dfs(root);
        return ret;
    }
    //二叉搜索树中序遍历从小到大有序
    public void dfs(TreeNode root){
        if (root == null)return;
        dfs(root.left);
        if (prev != null){
            ret = Math.min(root.val - prev.val,ret);
        }
        prev = root;
        dfs(root.right);
    }
}
