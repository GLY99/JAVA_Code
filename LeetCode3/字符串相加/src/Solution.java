//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
public class Solution {
    public String AddLongInteger(String addend,String augend){
        StringBuilder ret = new StringBuilder();
        int carry = 0;//保存进位信息
        int i = addend.length() - 1;
        int j = augend.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0){
            int sum = carry;
            if (i >= 0){
                sum += addend.charAt(i--) - '0';
            }
            if (j >= 0){
                sum += augend.charAt(j--) - '0';
            }
            ret.append(sum % 10);//无论是否大于10将模10的结果加入到结果集中
            carry = sum / 10;//记录余数信息，并且每次将余数置为0
        }
        return ret.reverse().toString();
    }
}
