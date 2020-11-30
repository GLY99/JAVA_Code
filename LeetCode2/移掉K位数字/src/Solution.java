import java.util.*;
//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
public class Solution {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0)return null;
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()){
            while (k > 0 && !stack.isEmpty() && c < stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (k > 0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        while (stringBuilder.length() > 1 && stringBuilder.charAt(stringBuilder.length() - 1) == '0'){
            stringBuilder.delete(stringBuilder.length() - 1,stringBuilder.length());
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.reverse().toString();
    }
}
