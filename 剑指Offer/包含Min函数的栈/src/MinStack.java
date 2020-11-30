//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
import java.util.*;
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()){
            minStack.push(x);
        }else{
            if (x <= minStack.peek()){
                minStack.push(x);
            }
        }
    }

    public void pop() {
        if (!stack.isEmpty()){
            int tmp = stack.pop();
            if (tmp == minStack.peek()){
                minStack.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
