import java.util.*;
public class MyStack {
    private Queue<Integer> que1;
    private Queue<Integer> que2;
    /** Initialize your data structure here. */
    public MyStack() {
        que1 = new LinkedList<>();
        que2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (que1.isEmpty() && que2.isEmpty()){
            que1.offer(x);
        }else {
            if (que1.isEmpty()){
                que2.offer(x);
            }else {
                que1.offer(x);
            }
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty())return -1;
        if (!que1.isEmpty()){
            for (int i = que1.size() - 1;i > 0;i--){
                que2.offer(que1.poll());
            }
            return que1.poll();
        }else {
            for (int i = que2.size() - 1;i > 0;i--){
                que1.offer(que2.poll());
            }
            return que2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if (empty())return -1;
        int tmp = -1;
        if (!que1.isEmpty()){
            for (int i = que1.size();i > 0;i--){
                tmp = que1.poll();
                que2.offer(tmp);
            }
        }else {
            for (int i = que2.size();i > 0;i--){
                tmp = que2.poll();
                que1.offer(tmp);
            }
        }
        return tmp;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (que1.isEmpty() && que2.isEmpty()){
            return true;
        }
        return false;
    }
}
