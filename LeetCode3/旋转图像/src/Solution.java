//给定一个 n × n 的二维矩阵表示一个图像。
//
//将图像顺时针旋转 90 度。
public class Solution {
    public void rotate(int[][] matrix){
        for (int i = 0;i < matrix.length;i++){
            for (int j = i;j < matrix[i].length;j++){
                if (i != j){
                    swap(matrix,i,j);
                }
            }
        }
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix[i].length / 2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - j - 1];
                matrix[i][matrix[i].length - j - 1] = temp;
            }
        }
    }
    public void swap(int[][] matrix,int i,int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
