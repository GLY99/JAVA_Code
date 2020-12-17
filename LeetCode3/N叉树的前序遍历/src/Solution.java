import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
//递归
public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null)return ret;
        ret.add(root.val);
        for (Node node : root.children){
            if (node == null) return null;
            List<Integer> list = preorder(node);
            ret.addAll(list);
        }
        return ret;
    }
}
//迭代
class SolutionI{
    public List<Integer> preorder(Node root){
        List<Integer> ret = new ArrayList<>();
        if (root == null)return ret;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node top = stack.pop();
            ret.add(top.val);
            for (int i = top.children.size() - 1;i >= 0;i--){
                stack.push(top.children.get(i));
            }
        }
        return ret;
    }
}
