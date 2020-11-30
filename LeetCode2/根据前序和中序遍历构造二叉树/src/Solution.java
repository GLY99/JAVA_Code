class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public static int preindex;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)return null;
        if (preorder.length == 0 || inorder.length == 0)return null;
        preindex = 0;
        return buildTreeChild(preorder,inorder,0,inorder.length - 1);
    }
    public static TreeNode buildTreeChild(int[] preorder,int[] inorder,int inbegin,int inend){
        if (inend < inbegin)return null;
        TreeNode root = new TreeNode(preorder[preindex]);
        int inorderindex = findInorderIndexOfRoot(inorder,inbegin,inend,preorder[preindex]);
        preindex++;
        root.left= buildTreeChild(preorder,inorder,inbegin,inorderindex - 1);
        root.right= buildTreeChild(preorder,inorder,inorderindex + 1,inend);
        return root;
    }
    public static int findInorderIndexOfRoot(int[] inorder,int inbegin,int inend,int val){
        for (int i = inbegin;i <= inend;i++){
            if (inorder[i] == val){
                return i;
            }
        }
        return -1;
    }
}