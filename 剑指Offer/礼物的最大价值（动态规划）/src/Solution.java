//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
// 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
// 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
public class Solution {
    public int maxValue(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        for (int j = 1;j < c;j++){
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1;i < r;i++){
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1;i < r;i++){
            for(int j = 1;j < c;j++){
                grid[i][j] = Math.max(grid[i - 1][j],grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[r - 1][c - 1];
    }
    public int maxValueI(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                if (i == 0 && j == 0){
                    continue;
                }else {
                    if (i == 0){
                        grid[i][j] += grid[i][j - 1];
                    }else {
                        if (j == 0){
                            grid[i][j] += grid[i - 1][j];
                        }else {
                            grid[i][j] = Math.max(grid[i - 1][j],grid[i][j - 1]) + grid[i][j];
                        }
                    }
                }
            }
        }
        return grid[r - 1][c - 1];
    }
}
