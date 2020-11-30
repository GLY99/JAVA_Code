import java.util.*;

public class Solution {
    //给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
    //每次「迁移」操作将会引发下述活动：
    //位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
    //位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
    //位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
    //请你返回 k 次迁移操作后最终得到的 二维网格。
    public List<List<Integer>> shiftGrid(int[][] grid, int k){
        int[] nums = new int[grid.length * grid[0].length];
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                k %= nums.length;
                nums[k++] = grid[i][j];
            }
        }
        int size = 0;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0;i < grid.length;i++){
            List<Integer> temp = new ArrayList<>();
            for (int j = 0;j < grid[0].length;j++){
                temp.add(nums[size++]);
            }
            lists.add(temp);
        }
        return lists;
    }
}
