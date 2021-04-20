import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int lastSize = res.size();//上一次长度
        res.add(new ArrayList<>());
        int newSize = res.size();//新的长度
        int len = nums.length;
        for (int i = 0;i < len;i++){
            int tmpLen = lastSize;//记录上一次的长度
            lastSize = newSize;//更新这一次的长度
            int j = 0;
            if (i != 0 && nums[i] == nums[i - 1]) {
                //如果有重复那么当前数字只和新产生的发生匹配
                j = lastSize - (lastSize - tmpLen);
            }
            for (;j < lastSize;j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
            newSize = res.size();//更新最新的长度
        }
        return res;
    }
}