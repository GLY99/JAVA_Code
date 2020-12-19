//如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
//
//例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。
// 相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
//
//给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。

public class Solution {
    //动态规划
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2)return n;
        int up = 1;//记录波峰
        int down = 1;//记录波谷
        for (int i = 1;i < n;i++){
            if (nums[i] > nums[i - 1]){//遇见一个递增的
                up = down + 1;//波峰长度+1
            }else {
                if (nums[i] < nums[i - 1]){//遇见一个递减的
                    down = up + 1;//波谷长度+1
                }
            }
        }
        return up > down ? up : down;//两个最大值就是长度
    }
    //贪心
    public int wiggleMaxLengthI(int[] nums){
        int n = nums.length;
        if (n < 2)return n;
        int ret = 0;
        int pre = nums[1] - nums[0];
        ret = pre != 0 ? 2 : 1;//前两个是否是摆动序列
        for (int i = 2;i < n;i++){
            int temp = nums[i] - nums[i - 1];
            if ((temp > 0 && pre <= 0) || (temp < 0 && pre >= 0)){//前面的无论是否摆动，遇见摆动的长度加1；
                ret ++;
                pre = temp;
            }
        }
        return ret;
    }
}
