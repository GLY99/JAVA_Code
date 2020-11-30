package I;
//斐波那契数列。答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
public class Solution {
    public int fib(int n){
        if (n == 0)return 0;
        if (n == 1)return 1;
        int f0 = 0;
        int f1 = 1;
        int f3 = 0;
        for (int i = 2;i <= n;i++){
            f3 = f0 + f1;
            if(f3 >= 1000000007){
                f3 -= 1000000007;
            }
            f0 = f1;
            f1 = f3;
        }
        return f3;
    }
}
