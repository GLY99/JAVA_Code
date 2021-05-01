import java.util.Stack;

class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        String string = s.trim();
        int len = string.length();
        StringBuilder res = new StringBuilder();
        int start = len - 1;
        int end = len - 1;
        while (start >= 0){
            while (end >= 0 && string.charAt(end) != ' '){
                end--;
            }
            res.append(string.substring(end + 1,start + 1) + " ");
            while (end >= 0 && string.charAt(end) == ' '){
                end--;
            }
            start = end;
        }
        return res.toString().trim();
    }
    public String reverseWords1(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        String[] strings = s.split(" ");
        Stack<String> stack = new Stack<>();
        for (String string : strings){
            if ("".equals(string)){
                continue;
            }
            stack.add(string);
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.pop() + " ");
        }
        return res.toString().trim();
    }
}