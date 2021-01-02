import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。*/
public class Solution {
    public int[] maxSlidingWindow(int[] nums,int k){
        if (nums == null || nums.length == 0 || k < 2){
            return nums;
        }
        int[] ret = new int[nums.length - k + 1];//定义返回数组
        LinkedList<Integer> queue = new LinkedList<>();//定义存储下标的双端队列
        for (int i = 0;i < nums.length;i++){
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){//维护一个单调递减的队列
                queue.pollLast();
            }
            queue.addLast(i);//添加当前值对应的数组下标
            if (queue.peek() <= i - k){//队首下标是否满足窗口大小
                queue.poll();
            }
            if (i + 1 >= k){//长度是否达到窗口大小
                ret[i + 1 - k] = nums[queue.peek()];
            }
        }
        return ret;
    }
}
