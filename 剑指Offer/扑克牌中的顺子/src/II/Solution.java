package II;

import java.util.Arrays;

public class Solution {
    public boolean isStraight(int[] nums){
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0;i < nums.length - 1;i++){
            if (nums[i] == 0){
                count++;
            }
            if (nums[i] != 0 && nums[i] == nums[i + 1]){
                return false;
            }
        }
        return nums[4] - nums[count] < 5;
    }
}
