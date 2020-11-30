package I;

import java.util.*;
public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<>();
        int l1 = nums1.length,l2 = nums2.length;
        if(Math.min(l1*l2,k)==0)return list;
        PriorityQueue<List<Integer>> pro = new PriorityQueue<>((o1, o2)->{
            return (o1.get(0) + o1.get(1)) - (o2.get(0) + o2.get(1));
        });

        for(int i = 0 ; i < Math.min(k,l1);i++ ) {
            for (int j = 0; j < Math.min(k, l2); j++) {
                List<Integer> tem = new ArrayList<>();
                tem.add(nums1[i]);
                tem.add(nums2[j]);
                pro.offer(tem);
            }
        }
        for(int m = 0;m < Math.min(l1*l2,k);m++){
            list.add(pro.poll());
        }
        return list;
    }
}
