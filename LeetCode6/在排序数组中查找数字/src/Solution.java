class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l < r){
            int mid = (l  + r) / 2;
            if (nums[mid] >= target){
                r = mid;
            }else {
                l = mid + 1;

            }
        }
        int s = l;
        r = len - 1;
        while (l < r){
            int mid = (r + l) / 2;
            if (nums[mid] > target){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        l = nums[l] == target ? l : l - 1;
        int e = l;
        return e - s + 1;
    }
}