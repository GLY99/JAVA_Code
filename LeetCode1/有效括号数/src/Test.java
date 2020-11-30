import java.util.Stack;
public class Test {
    public boolean isValid(String s){
        if(s.length() % 2 != 0)return false;
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else {
                if(c == '['){
                    stack.push(']');
                }else {
                    if(c == '{'){
                        stack.push('}');
                    }else if(stack.isEmpty() || c != stack.pop()){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
  /*  public boolean isValid(String s) {
        if(s.length() % 2 != 0)return false;
        Stack<Character> stack = new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }
            if(c == '['){
                stack.push(']');
            }
            if(c == '{'){
                stack.push('}');
            }
            if(c== '}'){
                if(stack.isEmpty() || c != stack.peek()){
                    return false;
                }else{
                    stack.pop();
                }
            }
            if(c== ')'){
                if(stack.isEmpty() || c != stack.peek()){
                    return false;
                }else{
                    stack.pop();
                }
            }
            if(c== ']'){
                if(stack.isEmpty() || c != stack.peek()){
                    return false;
                }else{
                    stack.pop();
                }
            }

        }
        return stack.isEmpty();
    }
}
