import java.util.ArrayList;
import java.util.List;
public class Solution {
    public int Fibonacci(int n){
        if (n == 0)return 0;
        if (n == 1)return 1;
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        dp.add(1);
        for (int i = 2;i <= n;i++){
            dp.add((dp.get(i - 1) + dp.get(i - 2)) % 1000000007);
        }
        return dp.get(n);
    }
    public int Fib(int n){
        if (n == 0 || n == 1)return n;
        int f1 = 0;
        int f2 = 1;
        int fn = 0;
        for (int i = 2;i <= n;i++){
            fn = (f1 + f2) % 1000000007;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }
}
