//统计所有小于非负整数 n 的质数的数量。

//如果 xx 是质数，那么大于 x 的 x 的倍数 2x,3x,一定不是质数
//每次找当前素数 xx 的倍数时，是从 x^2开始的。
// 因为如果 x > 2x>2，那么 2*x肯定被素数 2 给过滤了，最小未被过滤的肯定是 x^2

import java.util.Arrays;

public class Solution {
    public int countPrimes(int n){
        int[] isPrimes = new int[n];
        Arrays.fill(isPrimes,1);
        int count = 0;
        for (int i = 2;i < n;i++){
            if (isPrimes[i] == 1){
                count += 1;
                //要从i*i开始标记，所以要判断是否超出
               if ((long)i * i < n){
                    //进行标记非质数
                    for (int j = i * i;j < n;j += i){
                        isPrimes[j] = 0;
                    }
                }
            }
        }
        return count;
    }
    public int countPrimesII(int n) {
        int count = 0;
        for (int i = 2;i < n;i++){
            int j = 2;
            for (;j <= Math.sqrt(i);j++){
                if (i % j == 0){
                    break;
                }
            }
            if (j > Math.sqrt(i)){
                count++;
            }
        }
        return count;
    }
}
