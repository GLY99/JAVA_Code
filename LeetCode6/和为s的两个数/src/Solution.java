import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        List<int[]> list = new ArrayList<>();
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l < r){
            int sum = nums[l] + nums[r];
            if (sum == target){
                int[] res = new int[2];
                res[0] = nums[l];
                res[1] = nums[r];
                list.add(res);
                l++;
                r--;
            }else if (sum > target){
                r--;
            }else {
                l++;
            }
        }
        return list.get(0);
    }
}