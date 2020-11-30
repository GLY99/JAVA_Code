public class Solution {
    //二位数组查找。在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    // 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    public boolean findNumberIn2DArray(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0)return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        while (row < m && col >= 0){
            if (matrix[row][col] > target){
                col--;
            }else if (matrix[row][col] < target){
                row++;
            }else {
                return true;
            }
        }
        return false;
    }
}
