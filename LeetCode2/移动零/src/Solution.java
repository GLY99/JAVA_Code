//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
public class Solution {
    public void  moveZeroes(int[] nums){
        int index = 0;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length){
            nums[index++] = 0;
        }
    }
    //栈
    /*public void moveZeroes(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1;i >= 0;i--){
            if(nums[i] != 0){
                stack.add(nums[i]);
            }
        }
        for (int i = 0;i < nums.length;i++){
            while (!stack.isEmpty()){
                nums[i++] = stack.pop();
            }
            if (i < nums.length){
                nums[i] = 0;
            }
        }
    }*/
}
