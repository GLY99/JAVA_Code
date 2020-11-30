package I;
//三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。
// 结果可能很大，你需要对结果模1000000007。
public class Solution {
    public int waysToStep(int n){
        if (n == 1 || n == 2)return n;
        if (n == 3)return 4;
        int a = 1;
        int b = 2;
        int c = 4;
        int ret = 0;
        for (int i = 4;i <= n;i++){
            ret = (a + b) % 1000000007 + c;
            ret = ret % 1000000007;
            a = b;
            b = c;
            c = ret;
        }
        return ret;
    }
    /*public int waysToStep(int n){
        if (n == 1 || n == 2)return n;
        if (n == 3)return 4;
        int[] ret = new int[n];
        ret[0] = 1;
        ret[1] = 2;
        ret[2] = 3;
        for (int i = 3;i < n;i++){
            ret[i] = (ret[i - 1] + ret[i - 2]) % 1000000007 + ret[i - 3];
            ret[i] = ret[i] % 1000000007;
        }
        return ret[n - 1];
    }*/
}
