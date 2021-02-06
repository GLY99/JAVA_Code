/**给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。*/
public class Solution {
    public void rotate(int[] nums,int k){
        int len = nums.length;
        k = k % len;//如果k大于len
        reverse(nums,0,len - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,len - 1);
    }
    public void reverse(int[] nums,int start,int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
    public void rotateII(int[] nums,int k){
        int len = nums.length;
        for (int i = 0;i < k;i++){
            int temp = nums[len - 1];
            for (int j = len - 1;j > 0;j--){
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
    public void rotateI(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0;i < nums.length;i++){
            temp[i] = nums[i];
        }
        for (int i = 0;i < nums.length;i++){
            if (i < nums.length - k){
                nums[i + k] = temp[i];
            }else {
                nums[(i + k) % nums.length] = temp[i];
            }
        }
    }
}
