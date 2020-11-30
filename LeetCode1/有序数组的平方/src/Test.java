public class Test {
    public int[] sortedSquares(int[] A){
        int[] ans = new int[A.length];
        int left = 0;
        int rigth = A.length - 1;
        int k = A.length - 1;
        while (k >= 0){
            if (A[left] * A[left] > A[rigth] * A[rigth]){
                ans[k] = A[left] * A[left];
                left++;
                k--;
            }else {
                ans[k] = A[rigth] * A[rigth];
                rigth--;
                k--;
            }
        }
        return ans;
    }
}
