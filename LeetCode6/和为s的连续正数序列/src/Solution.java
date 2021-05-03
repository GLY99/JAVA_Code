import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int l = 1;
        int r = 1;
        int sum = 0;
        for (;r < target;r++){//不取等于数组中数的个数大于2
            sum += r;
            while (sum > target){
                sum -= l;
                l++;
            }
            if (sum == target){
                int[] array = new int[r - l + 1];
                int size = 0;
                for (int i = l;i <= r;i++){
                    array[size++] = i;
                }
                list.add(array);
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0;i < list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}