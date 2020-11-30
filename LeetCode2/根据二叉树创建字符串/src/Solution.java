import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    StringBuilder stringBuilder = new StringBuilder();
    public String tree2str(TreeNode t) {
        if (t == null)return "";
        stringBuilder.append(t.val);
        if (t.left == null){
            if (t.right == null){

            }else{
                stringBuilder.append("()");
            }
        }else{
            stringBuilder.append("(");
            tree2str(t.left);
            stringBuilder.append(")");
        }
        if (t.right == null){

        }else {
            stringBuilder.append("(");
            tree2str(t.right);
            stringBuilder.append(")");
        }
        return stringBuilder.toString();
    }
}
