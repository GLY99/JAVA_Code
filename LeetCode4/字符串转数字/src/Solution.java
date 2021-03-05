public class Solution {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int index = 0;
        //去除前导的空格
        while (index < len){
            if (chars[index] == ' '){
                index++;
            }else {
                break;
            }
        }
        //当全是空格时
        if (index == len){
            return 0;
        }
        //确定正负（true为负数，false为正数）
        boolean flag = false;
        if (chars[index] == '-'){
            flag = true;
            index++;
        }else if (chars[index] == '+'){
            flag = false;
            index++;
        }else if (!Character.isDigit(chars[index])){
            return 0;
        }
        int ret = 0;
        while (index < len && Character.isDigit(chars[index])){
            int temp = chars[index] - '0';
            //加上之后可能会越界，提前处理
            if (ret > (Integer.MAX_VALUE - temp) / 10){
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ret = ret * 10 + temp;
            index++;
        }
        return flag ? -ret : ret;
    }
}
