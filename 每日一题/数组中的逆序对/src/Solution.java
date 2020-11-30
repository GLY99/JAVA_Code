public class Solution {
    public static int count;
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0)return 0;
        count = 0;
        mergeSort(nums,0,nums.length - 1);
        return count;
    }
    public void mergeSort(int[] nums,int left,int right){
        if (left >= right)return;
        int mid = (right + left) / 2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid + 1,right);
        merge(nums,mid,left,right);
    }
    public void merge(int[] nums,int mid,int left,int right){
        int[] newArr = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int size = 0;
        while (l <= mid && r <= right){
            if (nums[l] > nums[r]){
                count += mid - l + 1;
                newArr[size++] = nums[r++];
            }else {
                newArr[size++] = nums[l++];
            }
        }
        while (l <= mid){
            newArr[size++] = nums[l++];
        }
        while (r <= right){
            newArr[size++] = nums[r++];
        }
        for (int i = 0; i < newArr.length; i++) {
            nums[left + i] = newArr[i];
        }
    }
}