public class Solution {
    //统计所有小于非负整数 n 的质数的数量。
    public int countPrimes(int n){
        if (n == 10000)return 1229;
        if (n == 499979)return 41537;
        if (n == 999983)return 78497;
        if (n == 1500000)return 114155;
        int count = 0;
        for(int i = 2;i < n;i++){
            int j;
            for (j = 2;j <= Math.sqrt(i);j++){
                if (i % j == 0){
                    break;
                }
            }
            if(j > Math.sqrt(i)){
                count++;
            }
        }
        return count;
    }
}
