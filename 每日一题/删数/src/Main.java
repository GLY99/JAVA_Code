import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。
// 以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            if (n > 1000){
                n = 999;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0;i < n;i++){
                queue.offer(i);
            }
            int count = 0;//用来统计是不是第三个
            while (queue.size() > 1){
                if (count != 2){
                    queue.offer(queue.poll());//不是第三个数从队头出来排到队尾
                    count++;
                }else {
                    queue.poll();//是第三个数直接走人
                    count = 0;
                }
            }
            System.out.println(queue.poll());
        }
    }
}
