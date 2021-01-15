//泰波那契序列 Tn 定义如下： 
//
//T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
//
//给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
public class Solution {
    //直接用递归的话会超时，给定的通项公式可以进一步推导 T(n) = T(n-1) + T(n-2) +T(n-3)， T(n-1) = T(n-4) + T(n-3) + T(n-2)，
    // 两者相减 T(n) - T(n-1) = T(n-1) - T(n-4)， 所以T(n) = 2T(n-1) - T(n+4)
    public int tribonacci(int n) {
        switch (n){
            case 0 : return 0;
            case 1 : return 1;
            case 2 : return 1;
            case 3 : return 2;
            case 4 : return 4;
        }
        return 2 * tribonacci(n - 1) - tribonacci(n - 4);
    }
}
