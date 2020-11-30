package I;

import java.util.Arrays;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k){
        Arrays.sort(arr);
        int[] ret = new int[k];
        for (int i = 0;i < k;i++){
            ret[i] = arr[i];
        }
        return ret;
    }
}
