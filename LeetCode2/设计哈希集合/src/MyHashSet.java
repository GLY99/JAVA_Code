public class MyHashSet {
    static class Node{
        public int key;
        public Node next;
        public Node(int key) {
            this.key = key;
        }
    }
    public Node[] array;
    public int usedSize;
    public MyHashSet() {
        this.array = new Node[10];
        this.usedSize = 0;
    }
    public void add(int key){
        int index = key % this.array.length;
        for(Node cur = this.array[index];cur != null;cur = cur.next){
            if (cur.key == key){
                return;
            }
        }
        Node node = new Node(key);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
        if (loadFactor() > 0.75){
            resize();
        }
    }
    public float loadFactor(){
        return this.usedSize * 1.0f / this.array.length;
    }
    public void resize(){
        Node[] newarray = new Node[this.array.length * 2];
        for (int i = 0;i < this.array.length;i++){
            Node curNext = null;
            for (Node cur = this.array[i];cur != null;cur = curNext){
                curNext = cur.next;
                int index = cur.key % newarray.length;
                cur.next = newarray[index];
                newarray[index] = cur;
            }
        }
        this.array = newarray;
    }
    public boolean contains(int key) {
        int index = key % this.array.length;
        for(Node cur = this.array[index];cur != null;cur = cur.next){
            if (cur.key == key){
                return true;
            }
        }
        return false;
    }
    public void remove(int key) {
        if(contains(key) == false)return;
        int index = key % this.array.length;
        Node prev = this.array[index];
        Node cur = prev.next;
        for(;cur != null;cur = cur.next){
            if(cur.key == key){
                prev.next = cur.next;
                return;
            }else{
                prev = cur;
            }
        }
        if(this.array[index].key == key){
            this.array[index] = this.array[index].next;
            return;
        }
    }
}
