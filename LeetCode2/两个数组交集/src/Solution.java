import java.util.*;
//编写一个函数找出两个数组共有元素
public class Solution {
    public int[] intersection(int[] nums1,int[] nums2){
        if (nums1 == null || nums2 == null){
            return null;
        }
        Set<Integer> set1 = new HashSet<>();
        for (int num1:nums1){
            set1.add(num1);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num2:nums2){
            if (set1.contains(num2)){
                set2.add(num2);
            }
        }
        int[] ret = new int[set2.size()];
        int size = 0;
        for (int num:set2){
            ret[size++] = num;
        }
        return ret;
    }
}
