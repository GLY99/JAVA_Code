//给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
//
//如果不能形成任何面积不为零的三角形，返回 0。

import java.util.Arrays;

public class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1;i >= 2;i--){
            int a = A[i];
            int b = A[i - 1];
            int c = A[i - 2];
            if (a < b + c){
                return a + b + c;
            }
        }
        return 0;
    }
}
