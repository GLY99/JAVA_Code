package II;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null)return null;
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        TreeNode newNode = new TreeNode(-1);
        TreeNode cur = newNode;
        for (int num:list){
            cur.right = new TreeNode(num);
            cur = cur.right;
        }
        return newNode.right;
    }
    public void inorder(TreeNode root,List<Integer> list){
        if (root == null)return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
