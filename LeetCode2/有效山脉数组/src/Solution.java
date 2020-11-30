public class Solution {
    //给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
    //A.length >= 3
    //在 0 < i < A.length - 1 条件下，存在 i 使得：
    //A[0] < A[1] < ... A[i-1] < A[i]
    //A[i] > A[i+1] > ... > A[A.length - 1]
    /*public static boolean valiMountainArray(int[] A){
        if (A.length < 3)return false;
        int left = 0;
        int right = A.length - 1;
        while (left < A.length - 1 && A[left] < A[left + 1]){
            left++;
        }
        while (right > 0 && A[right] < A[right - 1]){
            right--;
        }
        if (left != 0 && right != A.length - 1 && left == right){
            return true;
        }else {
            return false;
        }
    }*/
    public static boolean valiMountainArray(int[] A){
        int i = 0;
        while (i < A.length - 1 && A[i] < A[i + 1]){
            i++;
        }
        if (i == A.length - 1 || i == 0){
            return false;
        }
        while (i < A.length - 1 && A[i] > A[i + 1]){
            i++;
        }
        if (i == A.length - 1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = {0,3,2,1};
        boolean ret = valiMountainArray(A);
        System.out.println(ret);
    }
}
