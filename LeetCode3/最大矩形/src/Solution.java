//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
import java.util.Stack;
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int max = 0;
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix[i].length;j++){
                if (matrix[i][j] == '1'){
                    heights[j] += 1;
                }else {
                    heights[j] = 0;//0和周围组不成矩形
                }
            }
            max = Math.max(max,maxArea(heights));
        }
        return max;
    }
    public int maxArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int[] temp = new int[heights.length + 2];
        System.arraycopy(heights,0,temp,1,heights.length);
        int area  = 0;
        for (int i = 0;i < temp.length;i++){
            while (!stack.isEmpty() && temp[i] < temp[stack.peek()]){
                int h = temp[stack.pop()];
                area = Math.max(area,(i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }
        return area;
    }
}
