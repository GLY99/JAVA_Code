import java.util.*;
class Solution {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums1.length*nums2.length == 0 || k == 0)return ret;
        int l1 = nums1.length;
        int l2 = nums2.length;
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1));
            }
        });
        for (int i = 0;i < l1;i++){
            for (int j = 0;j < l2;j++){
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                if (queue.size() < k){
                    queue.offer(list);
                }else {
                    if ((list.get(0) + list.get(1)) < (queue.peek().get(0) + queue.peek().get(1))){
                        queue.poll();
                        queue.offer(list);
                    }
                }
            }
        }
        while (!queue.isEmpty()){
            ret.add(queue.poll());
        }
        return ret;
    }
    public static void main(String[] args){
        int[] num1 = {1,7,11};
        int[] num2 = {2,4,6};
        kSmallestPairs(num1,num2,3);
    }
}