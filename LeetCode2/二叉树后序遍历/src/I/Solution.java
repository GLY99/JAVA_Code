package I;

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
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null)return list;
        List<Integer> listLeft = postorderTraversal(root.left);
        list.addAll(listLeft);
        List<Integer> listRight = postorderTraversal(root.right);
        list.addAll(listRight);
        list.add(root.val);
        return list;
    }
    /*List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(I.TreeNode root) {
        help(root);
        return list;
    }
    public List<Integer> help(I.TreeNode root){
        if (root == null)return null;
        help(root.left);
        help(root.right);
        list.add(root.val);
        return list;
    }*/
}
