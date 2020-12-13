//给定一个整数数组，判断是否存在重复元素。
//
//如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。

import java.util.HashSet;

public class Solution {
    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums){
            if (set.contains(n)){
                return true;
            }else {
                set.add(n);
            }
        }
        return false;
    }
    public boolean containsDuplicateI(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums){
            set.add(n);
        }
        return set.size() < nums.length ? true : false;
    }
}
