public class MyCircularDeque {
    public int[] elem;
    public int usedSize;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.elem = new int[k];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()){
            return false;
        }
        for (int i = this.usedSize - 1;i >= 0;i--){
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[0] = value;
        this.usedSize++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()){
            return false;
        }
        this.elem[this.usedSize] = value;
        this.usedSize++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()){
            return false;
        }
        this.elem[0] = 0;
        for (int i = 0;i < this.usedSize - 1;i++){
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()){
            return false;
        }
        this.elem[this.usedSize - 1] = 0;
        this.usedSize--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()){
            return -1;
        }
        return this.elem[0];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()){
            return -1;
        }
        return this.elem[this.usedSize - 1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }
}
