/**n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。

 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。

 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
 */
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];//记录石头是否被移除
        List<List<Integer>> edge = new ArrayList<>();//记录在同一条边的石头
        //遍历数组，统计在同一条边的石头
        for (int i = 0;i < n;i++){
            edge.add(new ArrayList<>());
            for (int j = 1;j < n;j++){
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    edge.get(i).add(j);
                }
            }
        }
        int num = 0;
        for (int i = 0;i < n;i++){
            if (visited[i] != true){
                num++;
                dfs(i,edge,visited);
            }
        }
        return n - num;
    }
    public void dfs(int x,List<List<Integer>> edge,boolean[] visited){
        visited[x] = true;
        for (int y : edge.get(x)){
            if (visited[y] != true){
                dfs(y,edge,visited);
            }
        }
    }
}
