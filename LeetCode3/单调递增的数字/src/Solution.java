//给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
//（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

//如果整个数字 N 本身已经是按位单调递增的，那么最大的数字即为 N。
//不考虑 N 的限制，那么对于一个长度为 n 的数字，最大单调递增的数字一定是每一位都为 9 的数字。
public class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] chars = Integer.toString(N).toCharArray();//将数字转换为字符数组
        int i = 1;
        while (i < chars.length && chars[i - 1] <= chars[i]){//找到非递增的那一位
            i++;
        }
        if (i < chars.length){//当N本身不是递增的是否进入if
            while (i > 0 && chars[i - 1] > chars[i]){//从非递增的这一位开始让前面的每位都减一，并且保持递增
                chars[i - 1] -= 1;
                i--;
            }
            for (i = i + 1;i < chars.length;i++){//将后面所有的位数置为9
                chars[i] = '9';
            }
        }
        return Integer.parseInt(new String(chars));//输出字符数组
    }
}
