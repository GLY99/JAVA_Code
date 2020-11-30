//输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
// 例如输入字符串"I am a student. "，则输出"student. a am I"。
package I;
public class Solution {
    public String reverseWords(String s){
        String[] strings = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1;i >= 0;i--){
            if (strings[i].equals("")){//分割时遇见两个连续空格会产生一个Null
                continue;
            }else{
                stringBuilder.append(strings[i].trim()).append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }
}
