//给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
//题目保证至少有一个词不在禁用列表中，而且答案唯一。
//禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。

import java.util.*;

public class Solution {
    public static String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set = new HashSet<>();
        for (String s : banned){
            set.add(s);
        }
        HashMap<String,Integer> map = new HashMap<>();
        paragraph = paragraph.toLowerCase();
        String[] words = paragraph.split("[!?',;. ]");
        for (String s : words){
            if (s.equals("") || set.contains(s)){
                continue;
            }else {
                int count = map.getOrDefault(s,0) + 1;
                map.put(s,count);
            }
        }
        int max = 0;
        String ret = "";
        for (Map.Entry<String,Integer> m : map.entrySet()){
            if (m.getValue() > max){
                max = m.getValue();
                ret = m.getKey();
            }
        }
        return ret;
    }

}
