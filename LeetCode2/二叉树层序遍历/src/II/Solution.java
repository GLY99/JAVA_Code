package II;
//之字型层序遍历
//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int flag = 1;
        while(!queue.isEmpty()){
            List<Integer> rowlist = new ArrayList<>();
            int count = queue.size();
            while(count != 0){
                TreeNode cur = queue.poll();
                rowlist.add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                count--;
            }
            if(flag % 2 == 0){
                Collections.reverse(rowlist);
            }
            flag++;
            ret.add(rowlist);
        }
        return ret;
    }
}