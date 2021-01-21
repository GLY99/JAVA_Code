import java.util.Stack;

//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
public class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if (stack.contains(c)){
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(),i) != -1){//index of(char c,int index)返回c所在下标，以index作为起点搜索
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder ret = new StringBuilder();
        while (!stack.isEmpty()){
            ret.append(stack.pop());
        }
        return ret.reverse().toString();
    }
}
