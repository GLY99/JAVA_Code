/**对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。

 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ret = new ArrayList<>();
        int len = A.length - 1;
        int carry = 0;
        while (len >= 0 || K > 0 || carry != 0){
            int sum = carry;
            if (len >= 0){
                sum += A[len];
            }
            if (K > 0){
                sum += (K % 10);
            }
            ret.add(sum % 10);
            carry = sum / 10;
            K /= 10;
            len--;

        }
        Collections.reverse(ret);
        return ret;
    }
    public List<Integer> addToArrayFormI(int[] A, int K) {
        List<Integer> ret = new ArrayList<>();
        int len = A.length;
        for (int i = len - 1;i >= 0;i--){
            int sum = A[i] + K % 10;
            K /= 10;
            if (sum > 9){
                K++;
                sum -= 10;
            }
            ret.add(sum);
        }
        for (;K > 0;K /= 10){
            ret.add(K % 10);
        }
        Collections.reverse(ret);
        return ret;
    }
}
