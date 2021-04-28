class Solution {
    public int singleNumber(int[] nums) {
        int[] map = new int[32];
        //一个数字如果出现3次，那么他的每一位上的1都会出现3次
        for (int num : nums){
            for (int i = 31;i >= 0;i--){
                map[i] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0;
        //如果某一位上1的次数是3的倍数，那么他就不是结果
        for (int i = 31;i >= 0;i--){
            if (map[i] % 3 != 0){
                res += Math.pow(2,31 - i);
            }
        }
        return res;
    }
}