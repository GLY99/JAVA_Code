/**给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。

 你可以返回满足此条件的任何数组作为答案。*/
public class Solution {
    public int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left < right){
            while (left < right && A[left] % 2 == 0){
                left++;
            }
            while (left < right && A[right] % 2 != 0){
                right--;
            }
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
        }
        return A;
    }
}
