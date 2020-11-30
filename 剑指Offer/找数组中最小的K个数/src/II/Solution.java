package II;

public class Solution {
    public static int[] getLeastNumbers(int[] arr, int k){
        for(int i = 1;i <= arr.length-1;i++){
            boolean flag = false;
            for (int j = 0;j < arr.length - i;j++){
                if (arr[j] > arr[j + 1]){
                  int temp = arr[j];
                  arr[j] = arr[j + 1];
                  arr[j + 1] = temp;
                  flag = true;
                }
            }
            if (flag == false){
                break;
            }
        }
        int[] ret = new int[k];
        for(int i = 0;i < k;i++){
            ret[i] = arr[i];
        }
        return ret;
    }
}
