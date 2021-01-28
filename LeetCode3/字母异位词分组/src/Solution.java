//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
//示例:
//
//输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]

//异位词排序后的hash值相等
import java.util.*;
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);//得到key值
            List<String> list = map.getOrDefault(key,new ArrayList<>());//key值对应的list，如果是第一次新建一个list
            list.add(str);//添加单词
            map.put(key,list);//重新放入map
        }
        //遍历map，将所有的value放入ret中
        List<List<String>> ret = new ArrayList<>();
        for (Map.Entry<String,List<String>> entry: map.entrySet()){
            ret.add(entry.getValue());
        }
        return ret;
    }
}
