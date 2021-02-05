import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

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
public class Solution {
    /**迭代*/
    //前序遍历改为根右左，然后将结果逆序
    //入栈顺序先左后右
    public List<Integer> postorder(Node root){
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> ret = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            Node tempNode = stack.pop();
            ret.add(tempNode.val);
            for (int i = 0;i < tempNode.children.size();i++){
                stack.add(tempNode.children.get(i));
            }
        }
        Collections.reverse(ret);
        return ret;
    }
    /**递归*/
    public List<Integer> postorderI(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        post(root,list);
        return list;
    }
    public void post(Node root,List<Integer> list){
        if (root == null){
            return;
        }
        for (Node node : root.children){
            post(node,list);
        }
        list.add(root.val);
    }
}
