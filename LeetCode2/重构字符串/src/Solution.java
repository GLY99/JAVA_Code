//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
//
//若可行，输出任意可行的结果。若不可行，返回空字符串。
public class Solution {
    public static String reorganizeString(String S) {
        char[] chars = S.toCharArray();
        int[] bucket = new int[26];
        for (int i = 0;i < chars.length;i++){
            bucket[chars[i] - 'a']++;
        }//统计每个字符出现的次数
        int maxCount = 0;
        int index = 0;
        for (int i = 0;i < 26;i++){
            if (bucket[i] > maxCount){
                maxCount = bucket[i];
                index = i;
            }
            if (maxCount > (S.length() + 1) >> 1){
                return "";
            }
        }//判断出现次数最多的字符出现次数是否超过一半，以及其下标
        char[] retChars = new char[S.length()];
        int j = 0;
        while (bucket[index] != 0){
            retChars[j] = (char) (index + 'a');
            bucket[index]--;
            j = j + 2;
        }//将出现次数最多的字符放在所有的偶数位
        for (int i = 0;i < bucket.length;i++){
            while (bucket[i] != 0){
                if (j >= retChars.length){
                    j = 1;
                }
                retChars[j] = (char)(i + 'a');
                bucket[i]--;
                j = j + 2;
            }
        }//将其余字符放在未放满的偶数位，以及所有的奇数位
        return new String(retChars);
    }
}
