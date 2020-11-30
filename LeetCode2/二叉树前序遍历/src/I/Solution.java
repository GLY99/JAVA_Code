package I;
//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
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
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null)return list;
        list.add(root.val);
        List<Integer> listLeft = preorderTraversal(root.left);
        list.addAll(listLeft);
        List<Integer> listRight = preorderTraversal(root.right);
        list.addAll(listRight);
        return list;
    }
    /*List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(I.TreeNode root){
        help(root);
        return list;
    }
    public void help(I.TreeNode root){
        if (root == null) return;
        list.add(root.val);
        help(root.left);
        help(root.right);
    }*/
}
