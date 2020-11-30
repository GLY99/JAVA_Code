package I;

public class Solution {
    public char firstUniqChar(String s){
        char[] dic = new char[26];
        for (int i = 0;i < s.length();i++){
            dic[s.charAt(i) - 'a']++;
        }
        for(int i = 0;i < s.length();i++){
            if (dic[s.charAt(i) - 'a'] == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
