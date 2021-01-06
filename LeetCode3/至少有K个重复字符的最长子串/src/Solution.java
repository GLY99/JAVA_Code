/**找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。*/
public class Solution {
    public int longestSubstring(String s, int k) {
        if (k < 2){
            return s.length();
        }
        return process(s.toCharArray(),k,0,s.length() - 1);
    }
    private int process(char[] s,int k,int start,int end){
        if (end - start + 1 < k){
            return 0;
        }
        int[] chars = new int[26];//记录字符出现的次数
        for (int i = start; i <= end;i++){
            chars[s[i] - 'a']++;
        }
        while (end - start + 1 >= k && chars[s[start] - 'a'] < k){//找到满足条件的字符起始位置
            start++;
        }
        while (end - start + 1 >= k && chars[s[end] - 'a'] < k){//找到满足条件的字符结束位置
            end--;
        }
        if (end - start + 1 < k){
            return 0;
        }
        for (int i = start;i <= end;i++){
            if (chars[s[i] - 'a'] < k){
                return Math.max(process(s,k,start,i - 1),process(s,k,i + 1,end));
            }
        }
        return end - start + 1;
    }
}
