class Solution {
    //n个筛子最大有 6*n个点数值
    //一共有 6^n种可能性
    //n个筛子的点数值为5*n(最小点数值为n)
    public double[] dicesProbability(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];//n个筛子出现点数的次数
        double[] ans =new double[5 * n + 1];//n个筛子点数的可能性
        double all = Math.pow(6,n);//总的可能性
        //初始化
        for (int i = 1;i < 6;i++){
            dp[1][i] = 1;
        }
        for (int i = 1;i <= n;i++){//i个筛子
            for (int j = i;j <= 6 * n;j++){//i个筛子掷出的点数
                for (int k = 1;k <= 6;k++){//第i个筛子掷出k点时
                    dp[i][j] += j >= k ? dp[i -1][j - k] : 0;
                    if (i == n){//最小点数
                        ans[j - i] = dp[i][j] / all;
                    }
                }
            }
        }
        return ans;
    }
}