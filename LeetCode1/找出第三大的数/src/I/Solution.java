package I;
//给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
public class Solution {
    public int thirdMax(int[] nums){
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        for (int num : nums){
            if (num > max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }else {
                if (num > max2 && num < max1){
                    max3 = max2;
                    max2 = num;
                }else {
                    if (num > max3 && num < max2){
                        max3 = num;
                    }
                }
            }
        }
        if (max3 != Long.MIN_VALUE){
            return new Long(max3).intValue();
        }
        return new Long(max1).intValue();
    }
}
