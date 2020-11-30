package I;
//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//全是负数或者全是正数不停更新ret;既有正数又有负数，由于负数越加越小所以当sum小于0时，更新ret即可，当sum大于0进行累加，再更新ret。
public class Solution {
    public int maxSubArray(int[] nums){
        if (nums.length == 0)return 0;
        int ret = nums[0];
        int sum = nums[0];
        for (int i = 1;i < nums.length;i++){
            if (sum < 0){
                sum = nums[i];
            }else {
                sum += nums[i];
            }
            if (sum > ret){
                ret = sum;
            }
        }
        return ret;
    }
}
