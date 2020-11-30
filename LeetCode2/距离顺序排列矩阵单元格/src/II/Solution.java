package II;
import java.util.*;
public class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0){
        int maxDist = Math.max(r0,R - 1 - r0) + Math.max(c0,C - 1 - c0);//桶的数量
        List<List<int[]>> bucket = new ArrayList<>();//因为要根据距离往桶中放元素所以要定义为List<List<int[]>>。
        for(int i = 0;i <= maxDist;i++){
            bucket.add(new ArrayList<int[]>());//建桶
        }
        for (int i = 0;i < R;i++){
            for (int j = 0;j < C;j++){
                int d = dist(i,j,r0,c0);
                bucket.get(d).add(new int[]{i,j});//根据距离找到对应的位置，添加元素
            }
        }
        int[][] ret = new int[R * C][2];
        int size = 0;
        for (int i = 0;i <= maxDist;i++){//遍历距离
            for (int[] temp : bucket.get(i)){//根据距离从小到大取出桶中元素
                ret[size++] = temp;
            }
        }
        return ret;
    }
    public int dist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
