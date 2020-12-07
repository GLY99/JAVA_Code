package I;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String string = scanner.nextLine();
            String[] array = string.split(" ");
            int[] nums = new int[array.length - 1];
            for (int i = 0;i < nums.length;i++){
                nums[i] = Integer.parseInt(array[i]);
            }
            int k = Integer.parseInt(array[array.length - 1]);
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for (int i = 0;i < nums.length;i++){
                if (i < k){
                    priorityQueue.offer(nums[i]);
                }else {
                    if (nums[i] < priorityQueue.peek()){
                        priorityQueue.poll();
                        priorityQueue.offer(nums[i]);
                    }
                }
            }
            int[] ret = new int[k];
            for (int i = k - 1;i >= 0;i--){
                ret[i] = priorityQueue.poll();
            }
            for (int i = 0;i < k;i++){
                System.out.print(ret[i] + " ");
            }
        }
    }
}
