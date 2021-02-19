/**给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。*/
import java.util.Arrays;

public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max((nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]),(nums[0] * nums[1] * nums[nums.length - 1]));
    }
    public int maximumProductI(int[] nums){
        int min1 = Integer.MAX_VALUE;//最小的
        int min2 = Integer.MAX_VALUE;//第二小
        int max1 = Integer.MIN_VALUE;//最大的
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int i = 0;i < nums.length;i++){
            int x = nums[i];
            if (x < min1){
                min2 = min1;
                min1 = x;
            }else if(x < min2){
                min2 = x;
            }
            if (x > max1){
                max3 = max2;
                max2 = max1;
                max1 = x;
            }else if (x > max2){
                max3 = max2;
                max2 = x;
            }else if (x > max3){
                max3 = x;
            }
        }
        return Math.max(max1 * max2 * max3,min1 * min2 * max1);
    }
}
