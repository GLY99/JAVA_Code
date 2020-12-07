//有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
//移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
//在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
//返回尽可能高的分数。
//示例：
//输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
//输出：39
//解释：
//转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
//0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
public class Solution {
    public static int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for (int i = 0;i < m;i++){//遍历行
            if (A[i][0] == 0){
                reverseRow(A[i]);//反转行
            }
        }
        for (int j = 0;j < n;j++){
            int contOne = 0;//统计1的个数
            for (int i = 0;i < m;i++){
                contOne += A[i][j];
            }
            if (contOne <= m / 2){
                reverseCol(A,j);//反转列
            }
        }
        int ret = 0;
        for (int i = 0;i < m;i++){
            int temp = 0;
            for (int j = 0;j < n;j++){
                temp += (A[i][j]*Math.pow(2,n - 1 - j));
            }
            ret += temp;
        }
        return ret;
    }
    public static void reverseRow(int[] row){
        for (int i = 0;i < row.length;i++){
            row[i] = row[i] == 0 ? 1 : 0;
        }
    }
    public static void reverseCol(int[][] A,int col){
        for (int i = 0;i < A.length;i++){
            A[i][col] = A[i][col] == 0 ? 1 : 0;
        }
    }
}
