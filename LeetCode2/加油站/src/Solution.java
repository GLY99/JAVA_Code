//在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
//你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
//如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int run = 0;
        int count = 0;
        int start = 0;
        for (int i = 0;i < gas.length;i++){
            run += (gas[i] - cost[i]);
            count += (gas[i] - cost[i]);
            if (run < 0){
                start = i + 1;
                run = 0;
            }
        }
        return count < 0 ? -1 : start;
    }
}

