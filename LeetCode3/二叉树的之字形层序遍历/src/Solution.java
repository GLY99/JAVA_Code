
import java.util.*;

//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null){
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();//记录每层元素
        queue.offer(root);
        int row = 0;//标记是第几层
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> rowList = new ArrayList<>();
            while (size != 0){
                TreeNode temp = queue.poll();
                rowList.add(temp.val);
                if (temp.left != null){
                    queue.offer(temp.left);
                }
                if (temp.right != null){
                    queue.offer(temp.right);
                }
                size--;
            }
            if (row % 2 != 0){
                Collections.reverse(rowList);
                ret.add(rowList);
            }else {
                ret.add(rowList);
            }
            row++;
        }
        return ret;
    }
}
