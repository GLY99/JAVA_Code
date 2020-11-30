public class Solution {
    //给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
    public static boolean buddyStrings(String A, String B){
        if (A.length() != B.length())return false;
        int count = 0;
        int[] pos = new int[2];
        int size = 0;
        for (int i = 0;i < A.length();i++){
            if (A.charAt(i) != B.charAt(i)){
                count++;
                if (count >= 3){
                    break;
                }
                pos[size++] = i;
            }
        }
        if(count == 0){
            char[] dic = new char[26];
            for (int i = 0;i < A.length();i++){
                dic[A.charAt(i) - 'a']++;
            }
            int i;
            for (i = 0;i < 26;i++){
                if (dic[i] >= 2){
                    break;
                }
            }
            if (i >= 26){
                return false;
            }else {
                return true;
            }
        }
        if (count == 1 || count >= 3){
            return false;
        }
        if (count == 2){
            if (A.charAt(pos[0]) == B.charAt(pos[1]) && A.charAt(pos[1]) == B.charAt(pos[0])){
                return true;
            }
        }
        return false;
    }
}
