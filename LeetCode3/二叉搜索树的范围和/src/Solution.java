//给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)return 0;
        if (root.val > low && root.val < high){
            return root.val + rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high);
        }else {
            if (root.val < low){
                return rangeSumBST(root.right,low,high);
            } else {
                return rangeSumBST(root.left,low,high);
            }
        }
    }
     public int rangeSumBSTI(TreeNode root, int low, int high){
        int ret = 0;
        if (root == null)return ret;
        if (root.val >= low && root.val <= high){
            ret += root.val;
        }
        int sumLeft = rangeSumBSTI(root.left,low,high);
        ret += sumLeft;
        int sumRight = rangeSumBSTI(root.right,low,high);
        ret += sumRight;
        return ret;
     }
}
