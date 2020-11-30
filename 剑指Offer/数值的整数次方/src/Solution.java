public class Solution {
    //快速幂
    public static double myPow(double x, int n) {
        double result = 1.0;
        long b = n;
        if (n < 0){
            b = -b;
        }
        while (b != 0){
            if ((b & 1) == 1){
                result *= x;
            }
            x *= x;
            b >>= 1;
        }
        return n < 0 ? 1.0 / result : result;
    }
    public static double myPowI(double x,int n){
        if (n == 0)return 1;
        if (n < 0){
            return 1 / x * myPow(1 / x,-n - 1);
        }else {
            return (n & 1) == 1 ? x * myPow(x * x,n >> 1) : myPow(x * x,n >> 1);
        }
    }
}
