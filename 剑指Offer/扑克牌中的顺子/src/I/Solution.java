package I;
//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
// 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

import java.util.*;

public class Solution {
    public boolean isStraight(int[] nums){
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int min = 14;
        for (int num : nums){
            if (num == 0)continue;
            max = Math.max(max,num);
            min = Math.min(min,num);
            if (set.contains(num))return false;
            set.add(num);
        }
        return max - min < 5;
    }
}
