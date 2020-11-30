//给定一个 n × n 的二维矩阵表示一个图像。
//将图像顺时针旋转 90 度。
public class Solution {
    public static void rotate(int[][] matrix) {
        for (int i = 0;i < matrix.length;i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix.length / 2 + 1;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
    }
}
