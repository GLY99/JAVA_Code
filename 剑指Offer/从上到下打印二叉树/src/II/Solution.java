package II;
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public int[] levelOrder(TreeNode root) {
        int[] arr = new int[0];
        if(root == null) return arr;
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            ret.add(cur.val);
            if (cur.left != null){
                queue.offer(cur.left);
            }
            if (cur.right != null){
                queue.offer(cur.right);
            }
        }
        arr = new int[ret.size()];
        for (int i = 0;i < ret.size();i++){
            arr[i] = ret.get(i);
        }
        return arr;
    }
}
