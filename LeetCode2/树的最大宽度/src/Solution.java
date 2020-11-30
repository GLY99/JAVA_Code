import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)return 0;
        int maxwidth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        queue.offer(root);
        index.offer(1);
        while (!queue.isEmpty()){
            int size = queue.size();
            int left = index.peek();//最左边结点下标
            int i = 0;
            while (size != 0){
                TreeNode cur = queue.poll();
                i = index.poll();//最右边结点下标
                if (cur.left != null){
                    queue.offer(cur.left);
                    index.offer(i * 2);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                    index.offer(i * 2 + 1);
                }
                size--;
            }
            maxwidth = Math.max(maxwidth,i + 1 - left);
        }
        return maxwidth;
    }
}