//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
//
//你需要返回给定数组中的重要翻转对的数量。

public class Solution {
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length ==0)return 0;
        int[] newArray = new int[nums.length];
        return mergeSort(nums,newArray,0,nums.length - 1);
    }
    public int mergeSort(int[] nums,int[] newArray,int left,int right){
        if (left >= right)return 0;
        int mid = (left + right)/2;
        int count = mergeSort(nums,newArray,left,mid) + mergeSort(nums,newArray,mid + 1,right);



        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right){
            if (nums[l] > (long)2 * nums[r]){
                count += mid - l + 1;
                r++;
            }else {
                l++;
            }
        }
        l = left;
        r = mid + 1;
        int size = left;
        while (l <= mid && r <= right){
            if (nums[l] <= nums[r]){
                newArray[size++] = nums[l++];
            }else {
                newArray[size++] = nums[r++];
            }
        }
        while (l <= mid){
            newArray[size++] = nums[l++];
        }
        while (r <= right){
            newArray[size++] = nums[r++];
        }
        for (int i = left;i <= right;i++){
            nums[i] = newArray[i];
        }
        return count;
    }
}
