//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public static int posIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)return null;
        if (preorder.length ==0 || inorder.length == 0 || preorder.length != inorder.length)return null;
        int len = preorder.length;
        posIndex = 0;
        return buliderTreeChild(preorder,inorder,0,len - 1);
    }
    public TreeNode  buliderTreeChild(int[] preorder,int[] inorder,int left,int right){
        if (left > right)return null;
        TreeNode root = new TreeNode(preorder[posIndex]);
        posIndex++;
        int pos = findRootChild(root.val,inorder,left,right);
        root.left = buliderTreeChild(preorder,inorder,left,pos - 1);
        root.right = buliderTreeChild(preorder,inorder,pos + 1,right);
        return root;
    }
    public int findRootChild(int val,int[] inorder,int left,int right){
        for (int i = left;i <= right;i++){
            if (inorder[i] == val){
                return i;
            }
        }
        return -1;
    }
}
