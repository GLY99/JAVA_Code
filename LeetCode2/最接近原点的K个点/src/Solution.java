
class Point{
    public int[] points;
    public int dist;
    public Point(int[] points, int dist) {
        this.points = points;
        this.dist = dist;
    }
}
public class Solution {
    public static int[][] kClosest(int[][] points,int K) {
        Point[] heap = new Point[points.length];
        for (int i = 0;i < heap.length;i++){
            heap[i] = new Point(points[i],points[i][0] * points[i][0] + points[i][1] * points[i][1]);
        }
        createHeap(heap,K);
        for (int i = K;i < heap.length;i++){
            if (heap[i].dist < heap[0].dist){
                heap[0] = heap[i];
                adjustDown(0,heap,K);
            }
        }
        int[][] ret = new int[K][2];
        for (int i = 0;i < K;i++){
            ret[i] = heap[i].points;
        }
        return ret;
    }
    //建堆
    public static void  createHeap(Point[] heap,int k){
        for (int i = (k - 1) / 2;i >= 0;i--){
            adjustDown(i,heap,k);
        }
    }
    public static void adjustDown(int parent,Point[] heap,int len){
        int child = parent * 2 + 1;
        while (child < len){
            if (child + 1 < len && heap[child].dist < heap[child + 1].dist){
                child++;
            }
            if (heap[child].dist > heap[parent].dist){
                Point tmp = heap[parent];
                heap[parent] = heap[child];
                heap[child] = tmp;
                parent = child;
                child = parent * 2 + 1;
            }else {
                break;
            }
        }
    }
}
