public class Test {
    //在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
    // 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
    public int findRepeatNumber(int[] nums){
        int[] arr = new int[nums.length];
        for (int num : nums){
            arr[num] += 1;
        }
        int i;
        for (i = 0;i < nums.length;i++){
            if (arr[nums[i]] >= 2){
                break;
            }
        }
        return nums[i];
    }
}
