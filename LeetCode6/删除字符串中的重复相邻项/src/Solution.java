import java.util.Stack;

class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        sb.append(chars[0]);
        for (int i = 1;i < chars.length;i++){
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == chars[i]){
                sb.deleteCharAt(sb.length() - 1);
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
    public String removeDuplicates1(String S) {
        Stack<Character> stack = new Stack<>();
        char[] chars = S.toCharArray();
        stack.push(chars[0]);
        for (int i = 1;i < chars.length;i++){
            if (!stack.isEmpty() && stack.peek() == chars[i]){
                stack.pop();
            }else {
                stack.push(chars[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}