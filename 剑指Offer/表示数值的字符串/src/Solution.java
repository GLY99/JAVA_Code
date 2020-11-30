//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
// 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
public class Solution {
    //‘.’出现正确情况：只出现一次，且在e的前面
    //‘e’出现正确情况：只出现一次，且出现前有数字
    //‘+’‘-’出现正确情况：只能在开头和e后一位
    public static boolean isNumber(String s){
        if (s == null || s.length() == 0)return false;
        s = s.trim();
        boolean numflag = false;
        boolean potflag = false;
        boolean eflag = false;
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                numflag = true;
            }else {
                if (s.charAt(i) == '.' && potflag == false && eflag == false ){
                    potflag = true;
                }else {
                    if ((s.charAt(i) == 'e' || s.charAt(i) == 'E')&& eflag == false && numflag == true){
                        eflag = true;
                        numflag = false;
                    }else {
                        if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')){

                        }else {
                            return false;
                        }
                    }
                }
            }
        }
        return numflag;
    }
}
