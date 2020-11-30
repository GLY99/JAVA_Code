import java.util.*;
public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < A.length();i++){
            if (A.charAt(i) == '('){
                stack.add(')');
            }else {
                if (!stack.isEmpty() && A.charAt(i) == ')'){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
