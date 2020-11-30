//给定一个正整数，返回它在 Excel 表中相对应的列名称。例如:
//    1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB
public class Solution {
    public String convertToTitle(int n){
            if (n < 1)return "";
            StringBuilder ret = new StringBuilder();
            while (n > 0){
                n--;
                ret.append((char) ((n % 26) + 'A'));
                n = n / 26;
            }
            return ret.reverse().toString();
    }
}
