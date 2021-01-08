//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
//求在该柱状图中，能够勾勒出来的矩形的最大面积。

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int[] temp = new int[heights.length + 2];
        System.arraycopy(heights,0,temp,1,heights.length);
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0;i < temp.length;i++){
            while (!stack.isEmpty() && temp[stack.peek()] > temp[i]){
                int h = temp[stack.pop()];
                max = Math.max(max,(i - stack.peek() - 1)*h);
            }
            stack.push(i);
        }
        return max;
    }
    public int largestRectangleAreaI(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int max = 0;
        for (int i = 0;i < heights.length;i++){
            int h = heights[i];
            int w = 1;
            int j = i;
            while (++j < heights.length && heights[j] >= h){
                w++;
            }
            j = i;
            while (--j >= 0 && heights[j] >= h){
                w++;
            }
            max = Math.max(h * w,max);
        }
        return max;
    }
}
