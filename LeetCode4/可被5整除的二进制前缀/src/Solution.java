import java.util.ArrayList;
import java.util.List;
/**给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。

 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
*/
public class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ret = new ArrayList<>();
        int n = 0;
        for (int i = 0;i < A.length;i++){
            n <<= 1;
            n += A[i];
            n %= 10;
            ret.add(n % 5 == 0);
        }
        return ret;
    }
}
