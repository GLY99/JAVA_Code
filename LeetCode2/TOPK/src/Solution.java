import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static int[] topK(int[] array,int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;//从大到小，大根堆
            }
        });
        for (int i = 0;i < array.length;i++){
            if (i < k){
                maxHeap.add(array[i]);
            }
            if (i >= k){
                if (array[i] < maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.add(array[i]);
                }
            }
        }
        int[] ret = new int[k];
        for (int i = 0;i < k;i++){
            ret[i] = maxHeap.poll();
        }
        return ret;
    }
}
