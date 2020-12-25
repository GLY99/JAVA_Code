//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
//
//对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。
// 如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int findContentChildren(int[] g, int[] s){//g胃口 s饼干
        if (s == null || s.length == 0){
            return 0;
        }
        if (g == null || g.length == 0){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie = 0;
        while (child < g.length && cookie < s.length){
            if (g[child] <= s[cookie]){
                child++;
            }
            cookie++;
        }
        return child;
        /*int count = 0;
        for (int i = 0,j = 0;i < g.length && j < s.length;i++,j++){
            while (j < s.length && g[i] > s[j]){
                j++;
            }
            if (j < s.length){
                count++;
            }
        }
        return count;*/
    }
    public int findContentChildrenI(int[] g, int[] s) {//g胃口 s饼干
        if (s == null || s.length == 0){
            return 0;
        }
        if (g == null || g.length == 0){
            return 0;
        }
        PriorityQueue<Integer> child = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        PriorityQueue<Integer> cookie = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0;i < g.length;i++){
            child.offer(g[i]);
        }
        for (int i = 0;i < s.length;i++){
            cookie.offer(s[i]);
        }
        int count = 0;
        while (!child.isEmpty() && !cookie.isEmpty()){
            if (child.peek() <= cookie.peek()){
                child.poll();
                count++;
            }
            cookie.poll();
        }
        return count;
    }
}
