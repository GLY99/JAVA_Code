import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**有一堆石头，每块石头的重量都是正整数。

 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：

 如果 x == y，那么两块石头都会被完全粉碎；
 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。*/
public class Solution {
    public int lastStoneWeight(int[] stones){
        if (stones == null || stones.length == 0){
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0;i < stones.length;i++){
            queue.offer(stones[i]);
        }
        while (queue.size() >= 2){
            int x = queue.poll();
            int y = queue.poll();
            if (x > y){
                queue.offer(x - y);
            }
        }
        return queue.size() == 1 ? queue.poll() : 0;
    }
    public int lastStoneWeightI(int[] stones){
        if (stones == null || stones.length == 0){
            return 0;
        }
        Arrays.sort(stones);
        for (int i = stones.length - 1;i > 0;i--){
            stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
            stones[stones.length - 2] = 0;
            Arrays.sort(stones);
        }
        return stones[stones.length - 1];
    }
}
