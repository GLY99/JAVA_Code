public class Solution {
    public static int majorityElement(int[] nums){
        int count = 1;
        int ret = nums[0];
        for (int i = 1;i < nums.length;i++){
            if (ret == nums[i]){
                count++;
            }else {
                count--;
                if (count == 0){
                    ret = nums[i];
                    count = 1;
                }
            }
        }
        return ret;
    }
}
