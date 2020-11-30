package I;

import java.util.Arrays;

//顺时针打印矩阵
public class Solution {
    public static int[] spiralOrder(int[][] matrix){
        if(matrix.length == 0)return new int[0];
        int row = matrix.length;
        int col = matrix[0].length;
        int[] arr = new int[row * col];
        int size = 0;
        int t = 0;//上界
        int l = 0;//左界
        int r = col - 1;//右界
        int b = row - 1;//下界
        while (t <= b && l <= r){
            for (int i = l;i <= r;i++){
                arr[size++] = matrix[t][i];
            }
            t++;
            for (int i = t;i <= b;i++){
                arr[size++] = matrix[i][r];
            }
            r--;
            for (int i = r;i >= l && t <= b;i--){
                arr[size++] = matrix[b][i];
            }
            b--;
            for (int i = b;i >= t && l <= r;i--){
                arr[size++] = matrix[i][l];
            }
            l++;
        }
        return arr;
    }
}
