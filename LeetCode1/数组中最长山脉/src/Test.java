public class Test {
    //数组中最长山脉。输入：[2,1,4,7,3,2,5]
    //输出：5
    //解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
    public int longestMountain(int[] A){
        int[] left = new int[A.length];
        for (int i = 1;i < A.length;i++){
            if (A[i] > A[i - 1]){
                left[i] = left[i - 1] + 1;
            }
        }
        int[] right = new  int[A.length];
        for (int i = A.length - 2;i > 0;i--){
            if (A[i] > A[i + 1]){
                right[i] = right[i + 1] + 1;
            }
        }
        int ret = 0;
        for (int i = 0;i < A.length;i++){
            if (left[i] > 0 && right[i] > 0){
               ret = Math.max(ret,(left[i] + right[i]) + 1);
            }
        }
        return ret;
    }
}
