public class Solution {
    public static int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0)return 0;//排除空
        if (chars[0] >= 'a' && chars[0] <= 'z')return 0;//排除非+-数字
        int flag = 1;
        long ret = 0;
        int i = 0;
        if (chars[0] == '-'){
            flag = -1;
            i++;
        }else {
            if (chars[0] == '+'){
                i++;
            }
        }
        for (;i < chars.length;i++){
            if (chars[i] >= '0' && chars[i] <= '9'){
                ret = ret * 10 + (chars[i] - '0') * flag;
                if (ret > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }else {
                    if (ret < Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                }
            }else {
                break;
            }
        }
        return (int)ret;
    }
}