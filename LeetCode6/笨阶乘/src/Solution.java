import java.util.Stack;

class Solution {
    //模拟法
    public static int clumsy(int N) {
        Stack<Integer> stack = new Stack<>();
        stack.push(N);
        N--;
        int index = 0;
        while (N > 0){
            if (index % 4 == 0) {
                stack.push(stack.pop() * N);
            }else if (index % 4 == 1) {
                stack.push(stack.pop() / N);
            }else if (index % 4 == 2) {
                stack.push(N);
            }else if (index % 4 == 3) {
                stack.push(-N);
            }
            N--;
            index++;
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
    //数学法
    //当N大于4时，结果和N的关系是+2 +2 -1 +1
    public static int clumsy1 (int N) {
        if (N == 1){
            return 1;
        }else if (N == 2){
            return 2;
        }else if (N == 3){
            return 6;
        }else if (N == 4){
            return 7;
        }
        if (N > 4){
            if (N % 4 == 0) {
                return N + 1;
            }else if (N % 4 == 1 || N % 4 == 2) {
                return N + 2;
            }else if (N % 4 == 3) {
                return N - 1;
            }
        }
        return 0;
    }
}