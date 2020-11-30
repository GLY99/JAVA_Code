import java.util.*;

public class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        for (char c : t.toCharArray()){
            Integer count = map.get(c);
            if (count == null){
                return false;
            }else {
                if (count > 1){
                    map.put(c,count - 1);
                }else {
                    map.remove(c);
                }
            }
        }
        return map.isEmpty();
    }
    public boolean isAnagramI(String s, String t) {
        int[] sCounts = new int[26];
        int[] tCounts = new int[26];
        for (char c: s.toCharArray()){
            sCounts[c - 'a']++;
        }
        for (char c : t.toCharArray()){
            tCounts[c - 'a']++;
        }
        for (int i = 0;i < 26;i++){
            if (sCounts[i] != tCounts[i]){
                return false;
            }
        }
        return true;
    }
    public boolean isAnagramII(String s, String t){
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);
        return String.valueOf(schars).equals(String.valueOf(tchars));
    }
}
