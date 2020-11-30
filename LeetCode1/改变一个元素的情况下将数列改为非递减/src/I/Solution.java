package I;

public class Solution {
    public boolean checkPossibility(int[] nums){
        int count = 0;
        int pos = 0;
        for (int i = 0;i < nums.length - 1;i++){
            if (nums[i] > nums[i + 1]){
                pos = i;
                count++;
            }
            if (count >= 2){
                break;
            }
        }
        if (count >= 2){
            return false;
        }
        if (count == 0 || pos == 0 || pos == nums.length - 2)return true;
        if (nums[pos + 1] >= nums[pos - 1] || nums[pos+2] >= nums[pos]){
            return true;
        }
        return false;
    }
}
