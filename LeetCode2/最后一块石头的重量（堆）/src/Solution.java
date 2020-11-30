import java.util.Arrays;
class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        for (int i = stones.length - 1;i > 0;i--){
            stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
            stones[stones.length - 2] = 0;
            Arrays.sort(stones);
        }
        return stones[stones.length - 1];
    }
}