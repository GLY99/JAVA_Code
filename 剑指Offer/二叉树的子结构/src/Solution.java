//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//B是A的子结构， 即 A中有出现和B相同的结构和节点值。
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null)return false;
        if (B == null)return false;
        if(help(A,B))return true;
        if(isSubStructure(A.left,B))return true;
        if(isSubStructure(A.right,B))return true;
        return false;
    }
    //判断B是不是A的一部分,并不是判断B和A是否相等
    public boolean help(TreeNode A,TreeNode B){
        if (B == null)return true;
        if (A == null)return false;
        if (A.val != B.val)return false;
        return help(A.left,B.left) && help(A.right,B.right);
    }
}
