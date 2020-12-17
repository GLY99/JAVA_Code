//一个机器人在m×n大小的地图的左上角（起点）。
//机器人每次向下或向右移动。机器人要到达地图的右下角（终点）。
//可以有多少种不同的路径从起点走到终点？
public class Solution {
    //状态：
    //子状态：从(0,0)到达(1,0),(1,1),(2,1),...(m-1,n-1)的路径数
    //F(i,j): 从(0,0)到达F(i,j)的路径数
    //状态递推：
    //F(i,j) = F(i-1,j) + F(i,j-1)
    //初始化：
    //特殊情况：第0行和第0列
    //F(0,i) = 1
    //F(i,0) = 1
    //返回结果：
    //F(m-1,n-1)
    public int uniquePaths (int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0;i < m;i++){
            dp[i][0] = 1;
        }
        for (int j = 0;j < n;j++){
            dp[0][j] = 1;
        }
        for (int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
