//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//如果数组中不存在目标值 target，返回 [-1, -1]。
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1,-1};
        if (nums == null || nums.length == 0)return ret;
        int left = 0;
        int right = nums.length - 1;
        //找左边界，右侧逼近
        while (left < right){
            int mid = (left + right) >> 1;
            if (nums[mid] < target){//不加等于，让右侧逼近
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        if (nums[right] != target){
            return ret;
        }
        ret[0] = left;
        left = 0;
        right = nums.length - 1;
        //找右边界左侧逼近
        while (left < right){
            int mid = (left + right) >> 1;
            if (nums[mid] <= target){//加等于，让左侧逼近
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        if (nums[right] == target){
            right = right;
        }else {
            right = right - 1;
        }
        if (right == ret[0]){
            ret[1] = ret[0];
        }else {
            ret[1] = right;
        }

        return ret;
    }
}
