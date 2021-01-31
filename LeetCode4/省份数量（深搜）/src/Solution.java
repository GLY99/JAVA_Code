/**有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。

 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。

 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。

*/
public class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];//标记城市是否去过
        int count  = 0;
        for (int i = 0;i < isConnected.length;i++){
            if (visited[i] == false){
                findCity(isConnected,visited,i);
                count++;
            }
        }
        return count;
    }
    public void findCity(int[][] isConnected,boolean[] visited,int index ){
        visited[index] = true;//将当前城市标记为去过
        for (int i = 0;i < isConnected[index].length;i++){
            if (isConnected[index][i] == 1 && visited[i] == false){
                findCity(isConnected,visited,i);
            }
        }
    }
}
