package I;//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
import java.util.*;
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
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        help(root);
        return list;
        /*List<Integer> list = new ArrayList<>();
        if (root == null)return list;
        List<Integer> listLeft = inorderTraversal(root.left);
        list.addAll(listLeft);
        list.add(root.val);
        List<Integer> listRight = inorderTraversal(root.right);
        list.addAll(listRight);
        return list;*/
    }
    public List<Integer> help(TreeNode root){
        if (root == null)return null;
        help(root.left);
        list.add(root.val);
        help(root.right);
        return list;
    }
}
