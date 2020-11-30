import java.util.HashMap;
//给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < A.length;i++){
            int num = A[i];
            for (int j = 0;j < B.length;j++){
                int sum = num + B[j];
                int count = map.getOrDefault(sum,0) + 1;
                map.put(sum,count);
            }
        }
        int ret = 0;
        for (int i = 0;i <C.length;i++){
            int num = C[i];
            for (int j = 0;j < D.length;j++){
                int sum = num + D[j];
                if (map.containsKey(-sum)){
                    ret += map.get(-sum);
                }
            }
        }
        return ret;
    }
}
