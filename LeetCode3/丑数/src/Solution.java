//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。

//丑数等于前面的某个丑数乘以某个因子
public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0;
        int b = 0;
        int c = 0;//标记丑数
        for (int i = 1;i < n;i++){
            dp[i] = Math.min(dp[a] * 2,Math.min(dp[b] * 3,dp[c] * 5));//第i个丑数为前面的丑数 * 2或者*3或者*5的最小值
            if (dp[a] * 2 == dp[i]){//如果第i个丑数是前面某个丑数*2那么更新下标
                a++;
            }
            if (dp[b] * 3 == dp[i]){//如果第i个丑数是前面某个丑数*3那么更新下标
                b++;
            }
            if (dp[c] * 5 == dp[i]){//如果第i个丑数是前面某个丑数*5那么更新下标
                c++;
            }
        }
        return dp[n - 1];
    }
}
