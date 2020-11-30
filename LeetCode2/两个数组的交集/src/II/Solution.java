package II;
//给定两个数组，编写一个函数来计算它们的交集。
//示例 1：
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
//示例 2：
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
import java.util.*;
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2){
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1){
            set1.add(num);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums2){
            if (set1.contains(num)){
                set2.add(num);
            }
        }
        int[] ret = new int[set2.size()];
        int size = 0;
        for (int num : set2){
            ret[size++] = num;
        }
        return ret;
    }
}
