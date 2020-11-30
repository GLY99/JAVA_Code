import java.util.*;
//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
public class Test {
    public boolean backspaceCompare(String S, String T){
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0;i < S.length();i++){
            if (S.charAt(i) != '#'){
                stack1.push(S.charAt(i));
            }else {
                if (stack1.isEmpty()){
                    continue;
                }
                stack1.pop();
            }
        }
        for (int i = 0;i < T.length();i++){
            if (T.charAt(i) != '#'){
                stack2.push(T.charAt(i));
            }else {
                if (stack2.isEmpty()){
                    continue;
                }
                stack2.pop();
            }
        }
        if (stack1.size() != stack2.size()){
            return false;
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            if (stack1.peek() == stack2.peek()){
                stack1.pop();
                stack2.pop();
            }else {
                return false;
            }
        }
        return true;
    }
}
