import java.util.HashMap;

//给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
public class Solution {
    public int findMaxLength(int[] nums) {
        for (int i = 0;i < nums.length;i++){
            if (nums[i] == 0){
                nums[i] = -1;
            }
        }
        int sum = 0;
        int ret = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            sum += nums[i];
            if (sum == 0 && i > ret){
                ret = i + 1;
            }
            if (map.containsKey(sum)){
                ret = Math.max(ret,i - map.get(sum));//遇到相同的和就更新长度，因为去掉前面的和之后剩下的和为0
            }else {
                map.put(sum,i);
            }
        }
        return ret;
    }
}
