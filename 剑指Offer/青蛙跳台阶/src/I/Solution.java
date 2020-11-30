package I;

public class Solution {
    public int numWays(int n){
        if(n == 1 || n== 2)return n;
        int f1 = 1;
        int f2 = 2;
        int f3 = 0;
        for(int i = 3;i <= n;i++){
            f3 = f1 + f2;
            if (f3 > 1000000008){
                f3 -= 1000000007;
            }
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
