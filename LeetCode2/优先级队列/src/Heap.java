import java.util.Arrays;
public class Heap{
    public int[] elem;
    public int usedsize;
    public Heap(){
        this.elem = new int[10];
    }
    //建大堆
    public void buildHeapBig(int[] array){
        for (int i = 0;i < array.length;i++){
            this.elem[i] = array[i];
            this.usedsize++;
        }
        for (int i = (this.usedsize - 1) / 2;i >= 0;i--){
            adjustDownBig(i,this.usedsize);
        }
    }
    //向下调整大根堆
    public void adjustDownBig(int parent,int len){
        int child = (parent * 2) + 1;
        while (child < len){
            if (child + 1 < len && this.elem[child] < this.elem[child + 1]){
                child++;
            }
            if (this.elem[parent] < this.elem[child]){
                int temp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = temp;
                parent = child;
                child = (parent * 2) + 1;
            }else{
                break;
            }
        }
    }
    //建小堆
    public void buildHeapSmall(int[] array){
        for (int i = 0;i < array.length;i++){
            this.elem[i] = array[i];
            this.usedsize++;
        }
        for (int i = (this.usedsize - 1) / 2;i >= 0;i--){
            adjustDownSmall(i,this.usedsize);
        }
    }
    //向下调整小根堆
    public void adjustDownSmall(int parent,int len){
        int child = (parent * 2) + 1;
        while (child < len){
            if (child + 1 < len && this.elem[child] > this.elem[child + 1]){
                child++;
            }
            if (this.elem[parent] > this.elem[child]){
                int temp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = temp;
                parent = child;
                child = (parent * 2) + 1;
            }else {
                break;
            }
        }
    }
    //判满
    public boolean isFull(){
        if (this.usedsize == this.elem.length){
            return true;
        }
        return false;
    }
    //扩容
    public void increase(){
        this.elem = Arrays.copyOf(this.elem,this.usedsize * 2);
    }
    //入队列
    public void push(int val){
        if (isFull()){
            increase();
        }
        this.elem[this.usedsize] = val;
        this.usedsize++;
        adjustUp(this.usedsize - 1);
    }
    //向上调整(大堆)
    public void adjustUp(int child){
        int parent = (child - 1) / 2;
        while (child > 0){
            if (this.elem[parent] < this.elem[child]){
                int temp = this.elem[parent];
                this.elem[parent] = this.elem[child];
                this.elem[child] = temp;
                child = parent;
                parent = (child - 1) / 2;
            }else {
                break;
            }
        }
    }
    //判空
    public boolean isEmpty(){
        if (this.usedsize == 0){
            return true;
        }
        return false;
    }
    //出队列
    public void pop(){
        if (isEmpty())return;
        int temp = this.elem[0];
        this.elem[0] = this.elem[this.usedsize - 1];
        this.elem[this.usedsize - 1] = temp;
        this.usedsize--;
        adjustDownBig(0,this.usedsize);
    }
    //堆排序
    public void heapSort(){
        int len = this.usedsize - 1;
        while (len > 0){
            int tmp = this.elem[0];
            this.elem[0] = this.elem[len];
            this.elem[len] = tmp;
            adjustDownBig(0,len);
            len--;
        }
    }
}