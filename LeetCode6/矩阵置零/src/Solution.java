class Solution {
    //优化
    public void setZeroes1(int[][] matrix){
        int r = matrix.length;
        int c = matrix[0].length;
        boolean row = false;
        boolean col = false;
        //记录第一列有没有0
        for (int i = 0; i < r ;i++){
            if (matrix[i][0] == 0){
                col = true;
            }
        }
        //记录第一行有没有0
        for (int i = 0; i < c; i++){
            if (matrix[0][i] == 0){
                row = true;
            }
        }
        //用其它的行和列更新第一行和列
        for (int i = 1; i < r; i++){
            for (int j = 1; j < c; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //用第一行和列更新其它行
        for (int i = 1; i < r; i++){
            for (int j = 1; j < c; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        //更新第一行和列
        if (row){
            for (int i = 0; i < c; i++){
                matrix[0][i] = 0;
            }
        }
        if (col){
            for (int i = 0; i < r; i++){
                matrix[i][0] = 0;
            }
        }
    }
    //无优化
    public void setZeroes2(int[][] matrix) {
        int len1 = matrix.length;
        int len2 = matrix[0].length;
        boolean[] r = new boolean[len1];
        boolean[] c = new boolean[len2];
        for (int i = 0; i < len1; i++){
            for (int j = 0; j < len2; j++){
                if (matrix[i][j] == 0){
                    r[i] = true;
                    c[j] = true;
                }
            }
        }
        for (int i = 0; i < len1; i++){
            for (int j = 0; j < len2; j++){
                if (r[i] || c[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}