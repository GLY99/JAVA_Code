public class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long dp = 0;
        long max = 0;
        long sum = 0;
        for (int i = 0;i < 2 * arr.length;i++){
            if (dp < 0){
                dp = arr[i % arr.length];
            }else {
                dp += arr[i % arr.length];
            }
            max = Math.max(max,dp);
            if (i == arr.length - 1 && k == 1){
                return (int)max;
            }
            if (i < arr.length){
                sum += arr[i];
            }
        }
        return (int)((Math.max(0,sum) * (k - 2) + max)%1000000007);
    }
}
