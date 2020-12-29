/**给定一个已排序的正整数数组 nums，和一个正整数 n 。
 * 从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。
 * 请输出满足上述要求的最少需要补充的数字个数。。*/
public class Solution {
    //对于任意1≤y<x，y已经被覆盖，x在数组中，因此y+x也被覆盖，区间[x+1,2x−1]
    //（即区间[1,x−1] 内的每个数字加上x之后得到的区间）内的所有数字也被覆盖，由此可得区间[1,2x−1] 内的所有数字都被覆盖。
    //每次找到未被数组nums 覆盖的最小的整数x，在数组中补充x，然后寻找下一个未被覆盖的最小的整数，
    // 重复上述步骤直到区间[1,n] 中的所有数字都被覆盖。
    public int minPatches(int[] nums, int n) {
        int index = 0;
        long x = 1;
        int count = 0;
        while (x <= n){
            if (index < nums.length && nums[index] <= x){
                x += nums[index];
                index++;
            }else {
                x *= 2;
                count++;
            }
        }
        return count;
    }
}
