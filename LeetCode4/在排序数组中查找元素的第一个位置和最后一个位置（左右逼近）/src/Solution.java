/**给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

 如果数组中不存在目标值 target，返回 [-1, -1]。
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1,-1};
        if (nums == null || nums.length == 0)return ret;
        int left = 0;
        int right = nums.length - 1;
        //找左边界（右逼近）
        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] >= target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        if (nums[left] != target){
            return ret;
        }
        ret[0] = left;
        right = nums.length - 1;
        //找右边界（左逼近）
        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] > target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        left = nums[left] == target ? left : left - 1;
        ret[1] = left;
        return ret;
    }
}
