import java.util.Stack;

class Solution {
    //动态规划
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        int[] leftHeight = new int[len];//记录每一个点的最大左边界
        leftHeight[0] = height[0];
        for (int i = 1;i < len;i++) {
            leftHeight[i] = Math.max(leftHeight[i - 1],height[i]);
        }
        int[] rightHeight = new int[len];//记录每一个点的最大右边界
        rightHeight[len - 1] = height[len - 1];
        for (int i = len - 2;i >= 0;i--) {
            rightHeight[i] = Math.max(rightHeight[i + 1],height[i]);
        }
        int res = 0;
        for (int i = 0;i < len;i++){
            res += Math.min(leftHeight[i],rightHeight[i]) - height[i];
        }
        return res;
    }
    //单调栈
    public int trap1 (int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        Stack <Integer> stack = new Stack<>();
        int len = height.length;
        int res = 0;
        for (int i = 0;i < len;i++) {
            //维护一个单调递减的栈
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int leftHeight = stack.peek();
                int w = i - leftHeight - 1;//宽度
                int h = Math.min(height[i],height[leftHeight]) - height[top];//高度
                res += w * h;
            }
            stack.push(i);
        }
        return res;
    }
    //双指针
    public int trap2 (int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int leftHeight = 0;
        int rightHeight = 0;
        int res = 0;
        while (left <= right) {
            if (height[left] < height[right]) {
                res += Math.max(0,leftHeight - height[left]);
                leftHeight = Math.max(leftHeight,height[left]);
                left++;
            }else {
                res += Math.max(0,rightHeight - height[right]);
                rightHeight = Math.max(rightHeight,height[right]);
                right--;
            }
        }
        return res;
    }
}