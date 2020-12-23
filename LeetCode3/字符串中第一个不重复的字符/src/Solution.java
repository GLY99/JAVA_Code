import java.util.HashMap;
//找到字符串中第一个唯一字符
public class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0;i < s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        for (int i = 0;i < s.length();i++){
            if (map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
    public int firstUniqCharI(String s){
        int[] bucket = new int[26];
        for (int i = 0;i < s.length();i++){
            bucket[s.charAt(i) - 'a']++;
        }
        for (int i = 0;i < s.length();i++){
            if (bucket[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
    public int firstUniqCharII(String s){
        for (int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)){
                return i;
            }
        }
        return -1;
    }
}
