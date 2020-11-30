//给定两个字符串 s 和 t，判断它们是否是同构的。
//如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
//所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
import java.util.*;
public class Solution {
    public boolean idIsomorphic(String s,String t){
        return isIsomorphicHelp(s,t) && isIsomorphicHelp(t,s);
    }
    public boolean isIsomorphicHelp(String s, String t) {
        if (s.length() != t.length())return false;
        HashMap<Character,Character> map = new HashMap<>();
        for (int i = 0;i < s.length();i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if (!map.containsKey(s1)){
                map.put(s1,t1);
            }else {
                if (map.get(s1) != t1){
                    return false;
                }
            }
        }
        return true;
    }
}
