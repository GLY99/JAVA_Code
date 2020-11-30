package I;//层序遍历二叉树
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null)return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            List<Integer> rowlist = new ArrayList<>();
            while (count != 0){
                TreeNode cur = queue.poll();
                rowlist.add(cur.val);
                if (cur.left!= null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
                count--;
            }
            ret.add(rowlist);
        }
        return ret;
    }
}
