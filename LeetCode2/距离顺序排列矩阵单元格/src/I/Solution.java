package I;
//给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
//另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
//返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，
// 其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。

import java.util.*;

public class Solution {
    //直接排序
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] arr = new int[R * C][2];
        int size = 0;
        for (int i = 0;i < R;i++){
            for (int j = 0;j < C;j++){
                int[] temp = {i,j};
                arr[size++] = temp;
            }
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return dist(o1[0],o1[1],r0,c0) - dist(o2[0],o2[1],r0,c0);
            }
        });
        return arr;
    }
    public int dist(int r1,int c1,int r2,int c2){
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
    //快速排序
    public int[][] allCellsDistOrderI(int R, int C, int r0, int c0) {
        int[][] arr = new int[R * C][2];
        int size = 0;
        for (int i = 0;i < R;i++){
            for (int j = 0;j < C;j++){
                int[] temp = {i,j};
                arr[size++] = temp;
            }
        }
        quickSort(arr,r0,c0);
        return arr;
    }
    public void quickSort(int[][] array,int r0,int c0){
        int low = 0;
        int high = array.length - 1;
        int par = partion(array,low,high,r0,c0);
        Stack<Integer> stack = new Stack<>();
        if (par > low + 1){
            stack.add(low);
            stack.add(par - 1);
        }
        if (par < high - 1){
            stack.add(par + 1);
            stack.add(high);
        }
        while (!stack.isEmpty()){
            high = stack.pop();
            low = stack.pop();
            par = partion(array,low,high,r0,c0);
            if (par > low + 1){
                stack.add(low);
                stack.add(par - 1);
            }
            if (par < high - 1){
                stack.add(par + 1);
                stack.add(high);
            }
        }
    }
    public int partion(int[][] array,int low,int high,int r0,int c0){
        int[] flag = array[low];
        int temp = dist(array[low][0],array[low][1],r0,c0);
        while (low < high){
            while (low < high && dist(array[high][0],array[high][1],r0,c0) >= temp){
                high--;
            }
            if (low < high){
                array[low] = array[high];
            }else {
                break;
            }
            while (low < high && dist(array[low][0],array[low][1],r0,c0) <= temp){
                low++;
            }
            if (low < high){
                array[high] = array[low];
            }else {
                break;
            }
        }
        array[low] = flag;
        return low;
    }
}
