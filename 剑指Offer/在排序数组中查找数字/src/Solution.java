public class Solution {
    public int search(int[] nums, int target){
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid = 0;
        while (left <= right){
            mid = (left + right) / 2;
            if (nums[mid] == target){
                break;
            }else {
                if (nums[mid] > target){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        if (left > right){
            return 0;
        }
        int count = 0;
        left = mid - 1;
        while (left >= 0 && nums[left] == target){
            count++;
            left--;
        }
        right = mid;
        while (right < len && nums[right] == target){
            count++;
            right++;
        }
        return count;
    }
}
