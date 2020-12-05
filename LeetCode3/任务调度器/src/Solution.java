//给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。
//任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
//
//然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
//
//你需要计算完成所有任务所需要的 最短时间 。
//输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
//输出：16
//解释：一种可能的解决方案是：
//     A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A

import java.util.Arrays;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length <= 1 || n == 0)return tasks.length;
        int[] chars = new int[26];
        for (int i = 0;i < tasks.length;i++){
            chars[tasks[i] - 'A']++;
        }
        Arrays.sort(chars);
        int maxcount = 0;
        for (int i = 25;i >= 0;i--){
            if (chars[i] != chars[25]){
                break;
            }
            maxcount++;
        }
        return Math.max((chars[25] - 1) * (n + 1) + maxcount,tasks.length);
    }
}
