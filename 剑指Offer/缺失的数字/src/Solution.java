public class Solution {
    public int missingNumber(int[] nums){
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid = 0;
        while (left <= right){
            mid = (left + right) / 2;
            if (mid != nums[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        if (nums[mid] == mid){
            return mid + 1;
        }
        return mid;
    }
}
