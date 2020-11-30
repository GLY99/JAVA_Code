//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
package I;
import java.util.*;
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {
    LinkedList<List<Integer>> ret = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        help(root,sum);
        return ret;
    }
    public void help(TreeNode root,int sum){
        if (root == null)return;
        list.add(root.val);
        sum = sum - root.val;
        if (sum == 0 && root.left == null && root.right == null){
            ret.add(new LinkedList<>(list));
        }
        help(root.left,sum);
        help(root.right,sum);
        list.removeLast();//如果到了叶子结点后结果超过sum，则去掉List尾部元素，回朔到根。
    }
}
