import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
//
//如果可以完成上述分割，则返回 true ；否则，返回 false 。
public class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums){
            if (!map.containsKey(num)){
                map.put(num,new PriorityQueue<Integer>());//如果不存在创建一个Key,value为null
            }
            if (map.containsKey(num - 1)){//如果存在Num-1的key值
                int length = map.get(num - 1).poll();//取出长度，也就是取出num-1前的所有子序列
                if (map.get(num - 1).isEmpty()){//取出后为空，说明只有一个这样的子序列
                    map.remove(num - 1);//从map中删除key
                }
                map.get(num).offer(length + 1);//将num-1的子序列和num连接，添加长度
            }else {
                map.get(num).offer(1);//没有可以和num连接的子序列，将val赋值为1
            }
        }
        for (Map.Entry<Integer,PriorityQueue<Integer>> entry : map.entrySet()){
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3){
                return false;
            }
        }
        return true;
    }
}
