import java.util.Stack;
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.add(node);//入队一直往s1入
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()){
            return -1;
        }//两个栈都是空说明队列中没有元素
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
        }//当s2中没有元素时，将s1中元素全部搬入s2
        return stack2.pop();//出队一直从s2出
    }
}
