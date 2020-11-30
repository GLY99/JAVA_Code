//判断一个树是否镜像对称，先判断左右是否相同（判断树相同）；再判断左边的左边和右边的右边是否相同以及左边的右边和右边的左边是否相同。
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricChild(root.left,root.right);
    }
    public boolean isSymmetricChild(TreeNode left,TreeNode right){
        if (left == null && right == null)return true;
        if (left == null || right == null)return false;
        if (left.val != right.val)return false;
        return isSymmetricChild(left.left,right.right) && isSymmetricChild(left.right,right.left);
    }
}
