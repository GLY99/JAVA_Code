//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
//对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
//你可以返回任何满足上述条件的数组作为答案。

public class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < A.length && j >= 0){
            while (i < A.length && (A[i] & 1) == 0){
                i = i + 2;
            }
            while (j >= 0 && (A[j] & 1) != 0){
                j = j - 2;
            }
            if (i < A.length && j >= 0){
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
    public int[] sortArrayByParityII1(int[] A) {
        int j = 1;
        for (int i = 0;i < A.length - 1;i = i + 2){
            if ((A[i] & 1) != 0){
                while (j < A.length - 1){
                    if ((A[j] & 1) == 0){
                        break;
                    }
                    j = j + 2;
                }
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
}
