package org;
//优化
public class Solution {
    public static int matrixScore(int[][] A){
        int ret = 0;
        for (int j = 0;j < A[0].length;j++){//遍历列
            int countOne = 0;
            for (int i = 0;i < A.length;i++){//遍历行
                countOne += A[i][0] == 0 ? A[i][j]*-1+1 : A[i][j];//根据首位判断是否取反
            }
            if (countOne <= A.length / 2){//1的个数小于0的个数
                countOne = A.length - countOne;//将1和0的个数互换
            }
            ret += countOne * Math.pow(2,A[0].length - 1 - j);//计算结果（每一列都是该列1的个数*对应的2的次方）
        }
        return ret;
    }
}
