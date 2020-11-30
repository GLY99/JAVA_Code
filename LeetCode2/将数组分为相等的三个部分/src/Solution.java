public class Solution {
    //给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
    //形式上，如果可以找出索引 i+1 < j 且满足 
    // A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1] 就可以将数组三等分。
    public static boolean canThreePartsEqualSum(int[] A){
        int sum = 0;
        for (int i : A){
            sum += i;
        }
        int flag = 0;
        if (sum % 3 != 0){
            return false;
        }else {
           flag = sum / 3;
        }
        sum = 0;
        int count = 0;
        for (int i : A){
           sum += i;
           if (sum == flag){
               count++;
               sum = 0;
           }
        }
        if (flag != 0 && count == 3 || flag == 0 && count>3){
            return true;
        }
        return false;
    }
}
