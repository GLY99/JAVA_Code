package I;
//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
// 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。如果不存在最后一个单词，请返回 0 。

public class Solution {
    public static int lengthOfLastWord(String s){
        int count = 0;
        for (int i = s.length() - 1;i >= 0;i --){
            if (s.charAt(i) != ' '){
                count++;
            }else {
                if (count != 0){//末尾空格其它位置有单词
                    return count;//存在最后一个单词时返回
                }
            }
        }
        return count;//不存在最后一个单词时返回
    }
    /*public static int lengthOfLastWord(String s){
        String str = s.trim();
        int count  = 0;
        for (int i = str.length() - 1;i >= 0;i--){
            if (str.charAt(i) != ' '){
                count++;
            }else {
                break;
            }
        }
        return count;
    }*/
    /*public static int lengthOfLastWord(String s){
        String[] ret =  s.trim().split(" ");
        return ret[ret.length - 1].length();
    }*/
    public static void main(String[] args) {
        int ret = lengthOfLastWord("hello word");
        System.out.println(ret);
    }
}
