import java.util.Arrays;

/**给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
 返回该 最大总和 。
 */
class Solution {
    //排序后最大的和第二大的组队，依次类推
    public int arrayPairSum(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0;i < nums.length;i = i + 2){
            res += nums[i];
        }
        return res;
    }
}