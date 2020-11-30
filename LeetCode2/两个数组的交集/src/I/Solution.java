package I;
//给定两个数组，编写一个函数来计算它们的交集。
//示例 1：
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
//示例 2:
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9]
import java.util.*;
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            return intersect(nums2,nums1);
        }//将num1指向长度较短的数组。
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums1){
                int count = map.getOrDefault(num,0) + 1;
                map.put(num,count);
            }
        for (int num : nums2){
            int count = map.getOrDefault(num,0);
            if (count > 0){
                list.add(num);
                count --;
                if (count > 0){
                    map.put(num,count);
                }else {
                    map.remove(num);
                }
            }
        }
        int[] ret = new int[list.size()];
        int size = 0;
        for (int num : list){
            ret[size++] = num;
        }
        return ret;
    }
}
