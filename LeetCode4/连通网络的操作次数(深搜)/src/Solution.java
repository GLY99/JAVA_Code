import java.util.ArrayList;
import java.util.List;

/**用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。

 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。

 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。
 */
public class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1){
            return -1;
        }
        List<Integer>[] point = new List[n];
        for (int i = 0;i < n;i++){
            point[i] = new ArrayList<>();
        }
        //记录连接情况
        for (int[] con : connections){
            point[con[0]].add(con[1]);
            point[con[1]].add(con[0]);
        }
        boolean[] used = new boolean[n];
        int ret = 0;
        for (int i = 0;i < n;i++){
        	//如果当前结点没有访问过
            if (!used[i]){
                ret++;
                dfs(point,used,i);
            }
        }
        return ret - 1;
    }
    public void dfs(List<Integer>[] point,boolean[] used,int n){
        used[n] = true;
        for (int v : point[n]){
            if (!used[v]){
                dfs(point,used,v);
            }
        }
    }
}
