class Solution {
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        int[] res = new int[2];
        //找出单独数字的异或值
        int n = 0;
        for (int num : nums){
            n ^= num;
        }
        //找出可以区分两个数字的值(最低位的1)
        int flag = n & (-n);
        //开始对所有数进行分组
        for (int num : nums){
            if ((flag & num) == 0){
                res[0] ^= num;
            }else {
                res[1] ^= num;
            }
        }
        return res;
    }
}