/**实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。*/
public class Solution {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < str.length();i++){
            char temp = str.charAt(i);
            if (temp >= 'A' && temp <= 'Z'){
                //转换:A 65  a 97
                temp = (char) (temp + 32);
            }
            sb.append(temp);
        }
        return sb.toString();
    }
}
