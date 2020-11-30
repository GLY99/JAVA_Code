public class MyCircularQueue {
    public int[] elem;
    public int front;
    public int rear;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.elem = new int[k + 1];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        this.elem[rear] = value;
        this.rear = (rear + 1) % this.elem.length;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        this.front = (front + 1) % elem.length;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()){
            return -1;
        }
        return this.elem[this.front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        //int index = this.front == 0 ? this.elem.length-1 : this.rear - 1;
        int index = -1;
        if (this.rear == 0){
            index = this.elem.length - 1;
        }else {
            index = this.rear - 1;
        }
        return this.elem[index];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if (front == rear){
            return true;
        }
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if ((rear + 1) % this.elem.length == front){
            return true;
        }
        return false;
    }
}
