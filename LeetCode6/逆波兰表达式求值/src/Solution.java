import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < tokens.length;i++){
            String s = tokens[i];
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                if (s.equals("+")){
                    stack.push(a + b);
                }else if (s.equals("-")){
                    stack.push(a - b);
                }else if (s.equals("*")){
                    stack.push(a * b);
                }else if (s.equals("/")){
                    stack.push(a / b);
                }
            }else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}