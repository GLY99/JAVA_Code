/**LeetCode959*/
public class Solution {
    private static int[][] next = {{0,1},{0,-1},{1,0},{-1,0}};
    public  int regionsBySlashes(String[] grid){
        int row = grid.length;
        int col = grid[0].length();
        int res = 0;
        //构建网格
        int imgRow = row * 3 + 1;
        int imgCol = col * 3 + 1;
        int[][] img = new int[imgRow][imgCol];
        for (int i=0; i<imgRow; i++) {
            img[i][0] = 1;
            img[i][imgCol-1] = 1;
        }
        for (int i=0; i< imgCol; i++) {
            img[0][i] = 1;
            img[imgRow-1][i] = 1;
        }
        for (int i = 0;i < row;i++){
            for (int j = 0;j < col;j++){
                if (grid[i].charAt(j) == '/'){
                    int tempRow = i * 3;
                    int tempCol = (j + 1) * 3;
                    for (int k = 0;k < 4;k++){
                        img[tempRow + k][tempCol - k] = 1;
                    }
                }else if(grid[i].charAt(j) == '\\'){
                    int tempRow = i * 3;
                    int tempCol = j * 3;
                    for (int k = 0;k < 4;k++){
                        img[tempRow + k][tempCol + k] = 1;
                    }
                }
            }
        }
        int[][] book = new int[imgRow][imgCol];
        for (int i = 0;i < imgRow;i++){
            for (int j = 0;j < imgCol;j++){
                if (img[i][j] == 0 && book[i][j] == 0){
                    res++;
                    dfs(img,book,imgRow,imgCol,i,j);
                }
            }
        }
        return res;

    }
    public  void dfs(int[][] img,int[][] book,int imgRow,int imgCol,int x,int y){
        book[x][y] = 1;
        for (int i = 0;i < 4;i++){
            int nx = x + next[i][0];
            int ny = y + next[i][1];
            if (nx < 0 || ny < 0 || nx >= imgRow || ny >= imgCol){
                continue;
            }
            if (img[nx][ny] == 0 && book[nx][ny] == 0){
                dfs(img,book,imgRow,imgCol,nx,ny);
            }
        }
    }
}
