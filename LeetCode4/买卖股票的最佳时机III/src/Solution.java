/**给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）*/
public class Solution {
    public int maxProfit(int[] prices){
        if (prices == null || prices.length == 0){
            return 0;
        }
        int[][] dp = new int[2][2];//两次交易
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[1][1] = Integer.MIN_VALUE;
        for (int i = 0;i < prices.length;i++){
            dp[0][0] = Math.max(dp[0][0],dp[0][1] + prices[i]);//第一次卖出
            dp[0][1] = Math.max(dp[0][1],-prices[i]);//第一次买入
            dp[1][0] = Math.max(dp[1][0],dp[1][1] + prices[i]);//第二次卖出
            dp[1][1] = Math.max(dp[1][1],dp[0][0] - prices[i]);//第二次买入
        }
        return dp[1][0];
    }
}
