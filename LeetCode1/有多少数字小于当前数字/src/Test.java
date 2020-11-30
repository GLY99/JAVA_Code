public class Test {
    public int[] smallerNumbersThanCurrent(int[] nums){
        int[] arr = new int[101];
        for(int num : nums){
            arr[num] += 1;
        }
        for(int i = 1;i < 101;i++){
            arr[i] += arr[i - 1];
        }
        int[] ret = new int[nums.length];
        for (int i = 0;i < nums.length;i++){
            ret[i] = nums[i] == 0 ? 0 : arr[nums[i] - 1];
        }
        return ret;
    }
}
