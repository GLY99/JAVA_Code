//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
//这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

// 失败有两种情况： 1.key存在，经过查找字母对应的单词和这个单词不匹配； 2.key不存在，但是这个单词已经被存了；
import java.util.HashMap;
public class Solution {
    public boolean wordPattern(String pattern, String s) {
        if (pattern == null || s == null)return false;
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length)return false;
        HashMap<Character,String> map = new HashMap<>();
        for (int i = 0;i < strings.length;i++){
            if (!map.containsKey(pattern.charAt(i))){//如果key不存在，查看value是否存在。如果value不存在将新的Kv加入map
                if (map.containsValue(strings[i])){
                    return false;
                }else {
                    map.put(pattern.charAt(i),strings[i]);
                }
            }else {
                if (!map.get(pattern.charAt(i)).equals(strings[i])){//如果key存在，比较同一个key对应的value是否相同
                    return false;
                }
            }
        }
        return true;
    }
}
