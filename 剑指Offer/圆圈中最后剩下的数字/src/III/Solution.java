package III;
//约瑟夫环递推公式 ret = (m + ret) % i;ret表示最后活下的人，m为报的号，i为当前人数。
public class Solution {
    public int lastRemaining(int n, int m){
        int f = 0;
        for (int i = 2;i <= n;i++){
            f = (m + f) % i;
        }
        return f;
    }
}
