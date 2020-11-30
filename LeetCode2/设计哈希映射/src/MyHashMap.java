class MyHashMap {
    static class Node{
        public int data;//key
        public int val;//value
        public Node next;
        public Node(int data,int val) {
            this.data = data;
            this.val = val;
        }
    }
    public Node[] array;
    public int usedSize;
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.array = new Node[10];
        this.usedSize = 0;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % this.array.length;//取到数组地址
        for (Node cur = array[index]; cur != null; cur = cur.next){
            if (cur.data == key){
                cur.val = value;
                return;
            }
        }
        Node node = new Node(key,value);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
        if (loadFactor() > 0.75){
            resize();
        }
    }
    //负载因子
    public float loadFactor(){
        return this.usedSize * 1.0f / this.array.length;
    }
    //扩容
    public void resize(){
        Node[] newArray = new Node[2 * this.array.length];
        for (int i = 0;i < this.array.length;i++){
            Node curNext = null;
            for (Node cur = array[i]; cur != null; cur = curNext){
                curNext = cur.next;
                int index = cur.data % newArray.length;//取到数组地址
                cur.next = newArray[index];
                newArray[index] = cur;
            }
        }
        this.array = newArray;
    }
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % this.array.length;
        for (Node cur = this.array[index]; cur != null; cur = cur.next){
            if (cur.data == key){
                return cur.val;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if(get(key) == -1)return;
        int index = key % this.array.length;
        Node prev = this.array[index];
        Node cur = prev.next;
        for(;cur != null;cur = cur.next){
            if(cur.data == key){
                prev.next = cur.next;
                return;
            }else{
                prev = cur;
            }
        }
        if(this.array[index].data == key){
            this.array[index] = this.array[index].next;
            return;
        }
    }
}

