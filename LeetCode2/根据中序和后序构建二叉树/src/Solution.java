class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public int postindex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null)return null;
        if (inorder.length == 0 || postorder.length == 0)return null;
        postindex = postorder.length - 1;
        return buildTreeChild(inorder,postorder,0,inorder.length - 1);
    }
    public TreeNode buildTreeChild(int[] inorder,int[] postorder,int inbegin,int inend){
        if (inbegin > inend)return null;
        TreeNode root = new TreeNode(postorder[postindex]);
        int inorderindex = findIndexOfInorder(inorder,inbegin,inend,postorder[postindex]);
        postindex--;
        root.right = buildTreeChild(inorder,postorder,inorderindex + 1,inend);
        root.left = buildTreeChild(inorder,postorder,inbegin,inorderindex - 1);
        return root;
    }
    public int findIndexOfInorder(int[] inorder,int inbegin,int inend,int val){
        for (int i = inbegin;i <= inend;i++){
            if (inorder[i] == val){
                return i;
            }
        }
        return -1;
    }
}