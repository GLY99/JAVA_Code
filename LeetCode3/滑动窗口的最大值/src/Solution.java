import java.util.ArrayList;
import java.util.List;

//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
public class Solution {
    //暴力解法
    public  int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)return nums;
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i + k <= nums.length;i++){
            int max = nums[i];
            for (int j = i;j < i + k;j++){
                if (nums[j] > max){
                    max = nums[j];
                }
            }
            list.add(max);
        }
        int[] ret = new int[list.size()];
        for (int i = 0;i < list.size();i++){
            ret[i] = list.get(i);
        }
        return ret;
    }
}
