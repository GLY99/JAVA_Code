class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l < r){
            int mid = (l + r) / 2;
            //mid != i 左边确实，mid == i说明右边缺失
            if (nums[mid] != mid){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return nums[l] == l ? l + 1 : l;
    }
}