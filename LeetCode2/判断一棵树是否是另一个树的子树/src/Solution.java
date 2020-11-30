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
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)return false;
        return isSametree(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    public boolean isSametree(TreeNode p,TreeNode q){
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSametree(p.right,q.right) && isSametree(p.left,q.left);
    }
}
