public class Solution {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0)return 0;
        int[] newArray = new int[nums.length];
        return mergeSort(nums,newArray,0,nums.length - 1);
    }
    public int mergeSort(int[] nums,int[] newArray,int left,int right){
        if (left >= right)return 0;
        int mid = (right + left) / 2;
        int count = mergeSort(nums,newArray,left,mid) + mergeSort(nums,newArray,mid + 1,right);

        int l = left;
        int r = mid + 1;
        int size = left;
        while (l <= mid && r <= right){
            if (nums[l] > nums[r]){
                count += mid - l + 1;
                newArray[size++] = nums[r++];
            }else {
                newArray[size++] = nums[l++];
            }
        }
        while (l <= mid){
            newArray[size++] = nums[l++];
        }
        while (r <= right){
            newArray[size++] = nums[r++];
        }
        for (int i = left; i <= right; i++) {
            nums[i] = newArray[i];
        }
        return count;
    }
}