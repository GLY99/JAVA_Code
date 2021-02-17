/**给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。

 (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 */
import java.util.HashMap;
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (int i = 0;i < magazine.length();i++){
            map[magazine.charAt(i) - 'a'] += 1;
        }
        for (int i = 0;i < ransomNote.length();i++){
            map[ransomNote.charAt(i) - 'a'] -= 1;
            if (map[ransomNote.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
    public boolean canConstructI(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0;i < magazine.length();i++){
            int count = map.getOrDefault(magazine.charAt(i),0);
            map.put(magazine.charAt(i),count + 1);
        }
        for (int i = 0;i < ransomNote.length();i++){
            if (!map.containsKey(ransomNote.charAt(i))){
                return false;
            }
            int count = map.get(ransomNote.charAt(i)) - 1;
            if (count < 0){
                return false;
            }
            map.put(ransomNote.charAt(i),count);
        }
        return true;
    }
}
