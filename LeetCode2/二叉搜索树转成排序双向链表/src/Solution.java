class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
 }
public class Solution {
    TreeNode prev = null;
    public TreeNode Convert(TreeNode root){
        if (root == null)return null;
        ConvertChild(root);
        TreeNode head = root;
        while (head.left != null){
            head = head.left;
        }
        return head;
    }
    public void ConvertChild(TreeNode root){
        if (root == null)return;
        Convert(root.left);
        root.left = prev;
        if (prev != null){
            prev.right = root;
        }
        prev = root;
        Convert(root.right);
    }
}
