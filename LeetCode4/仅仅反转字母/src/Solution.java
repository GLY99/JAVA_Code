/**给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。*/
public class Solution {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int left = 0;
        int right = S.length() - 1;
        while (left < right){
            while (left < right && !Character.isLetter(chars[left])){
                left++;
            }
            while (left < right && !Character.isLetter(chars[right])){
                right--;
            }
            if (left < right){
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }
        }
        return new String(chars);
    }
}
