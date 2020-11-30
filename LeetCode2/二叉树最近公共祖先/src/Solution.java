class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
//如果pq分别在左右两侧则root为公共祖先，如果在同一侧，先找到的那个就是公共祖先。
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)return null;
        if (root == p || root == q)return root;//pq为root，或者pq找到pq时返回。
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left != null && right != null){//pq在两侧
            return root;
        }
        if (left != null){//pq在左侧
            return left;
        }
        return right;//pq在右侧
    }
}
