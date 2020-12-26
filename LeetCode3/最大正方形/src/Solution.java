//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
public class Solution {
    //dp[i][j]表示以第i行第j列为右下角所能构成的最大正方形边长
    //dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j],dp[i][j - 1]))
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        int max = 0;
        for (int i = 1;i <= row;i++){
            for (int j = 1;j <= col;j++){
                if (matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j],dp[i][j - 1]));
                    max = Math.max(dp[i][j],max);
                }
            }
        }
        return max*max;
    }
}
