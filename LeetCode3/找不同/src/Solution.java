//给定两个字符串 s 和 t，它们只包含小写字母。
//
//字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//
//请找出在 t 中被添加的字母。
public class Solution {
    public char findTheDifference(String s, String t) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0;i < s.length();i++){
            sum1 += s.charAt(i);
        }
        for (int i = 0;i < t.length();i++){
            sum2 += t.charAt(i);
        }
        return (char)(sum2 - sum1);
    }
    public char findTheDifferenceI(String s, String t){
        int[] bucket = new int[26];
        for (int i = 0;i < t.length();i++){
            if (i < s.length()){
                bucket[s.charAt(i) - 'a']++;
            }
            bucket[t.charAt(i) - 'a']--;
        }
        int index = 0;
        for (int i = 0;i < 26;i++){
            if (bucket[i] != 0){
                index = i;
            }
        }
        return (char)(index + 'a');
    }
    public char findTheDifferenceII(String s, String t){
        int ret = 0;
        for (char c : s.toCharArray()){
            ret ^= c;
        }
        for (char c : t.toCharArray()){
            ret ^= c;
        }
        return (char) ret;
    }
}
