import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Heap bigheap = new Heap();
        Heap smallheap = new Heap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        bigheap.buildHeapBig(array);
        System.out.println(Arrays.toString(bigheap.elem));
        smallheap.buildHeapSmall(array);
        System.out.println(Arrays.toString(smallheap.elem));
        bigheap.push(100);
        System.out.println(Arrays.toString(bigheap.elem));
        bigheap.pop();
        System.out.println(Arrays.toString(bigheap.elem));
        bigheap.heapSort();
        System.out.println(Arrays.toString(bigheap.elem));
    }
}
