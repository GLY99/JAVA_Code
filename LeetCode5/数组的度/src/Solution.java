import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。

 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 */
class Solution {
    public int findShortestSubArray(int[] nums){
        HashMap<Integer,Integer> map1 = new HashMap<>();//记录出现的频率
        HashMap<Integer,Integer> map2 = new HashMap<>();//记录出现的最后一次位置
        int maxCount = -1;
        //遍历数组记录频率以及最后一次出现的位置
        for (int i = 0;i < nums.length;i++){
            int count = map1.getOrDefault(nums[i],0);
            map1.put(nums[i],count + 1);
            map2.put(nums[i],i);
            maxCount = maxCount > map1.get(nums[i]) ? maxCount : map1.get(nums[i]);
        }
        //再次遍历数组找出最小子数组长度
        int res = Integer.MAX_VALUE;
        for (int i = 0;i < nums.length;i++){
            if (map1.get(nums[i]) == maxCount){
                res = res < map2.get(nums[i]) - i + 1 ? res : map2.get(nums[i]) - i + 1;
                map1.put(nums[i],-1);
            }
        }
        return res;
    }
    public int findShortestSubArray1(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxCount = 0;
        for (int num : nums){
            if (map.containsKey(num)){
                map.put(num,map.get(num) + 1);
                //记录最大频率
                maxCount = Math.max(maxCount,map.get(num));
            }else {
                map.put(num,1);
                //记录最大频率
                maxCount = Math.max(maxCount,1);
            }
        }
        List<Integer> list = new ArrayList<>();
        //取出所有最大频率对应的元素
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue() == maxCount){
                list.add(entry.getKey());
            }
        }
        int res = Integer.MAX_VALUE;
        for (int item : list){
            int l = 0;
            int r = nums.length - 1;
            while (nums[l] != item){
                l++;
            }
            while (nums[r] != item){
                r--;
            }
            res = Math.min(res,r - l + 1);
        }
        return res;
    }
}