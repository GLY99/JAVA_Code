/**如果数组是单调递增或单调递减的，那么它是单调的。*/
class Solution {
    public boolean isMonotonic(int[] A) {
        int len = A.length;
        boolean isIncrease = false;
        if (A[0] <= A[len - 1]){
            isIncrease = true;
        }
        for (int i = 0;i < len - 1;i++){
            if (isIncrease){
                if (A[i] > A[i + 1]){
                    return false;
                }
            }else {
                if (A[i] < A[i + 1]){
                    return false;
                }
            }
        }
        return true;
    }
}