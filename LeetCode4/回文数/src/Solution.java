/**判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。*/
public class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0){
            return true;
        }
        if (x < 0 || x % 10 == 0){
            return false;
        }
        int reversed = 0;
        while (x > reversed){
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }
        //位数为偶数 x == reversed
        //位数为奇数 x == reversed / 10;
        return x == reversed || x == reversed / 10;
    }
}
