package org;
import java.util.*;

class AllOne {
    class Node {
        Node pre, next;//前驱后继
        int val;//计数
        Set<String> content;//一个set
        Node(int v) {
            val = v; content = new HashSet<>();
        }
    }

    class DlinkedList {
        Node head, tail;//头尾结点
        DlinkedList() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.pre = head;
        }//初始化

        //插入到cur结点前
        void insert(Node cur, Node p) {
            p.pre = cur.pre;
            cur.pre.next = p;
            p.next = cur;
            cur.pre = p;
        }
        //插入到cur结点的后面
        void insertBack(Node cur, Node p) {
            p.next = cur.next;
            cur.next.pre = p;
            cur.next = p;
            p.pre = cur;
        }
        //删除cur结点
        void delete(Node cur) {
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
        }
    }

    Map<String, Node> mp;
    DlinkedList list;
    /** Initialize your data structure here. */
    public AllOne() {
        mp = new HashMap<>();
        list = new DlinkedList();
    }

    public void inc(String key) {
        if (mp.containsKey(key)) {
            Node p = mp.get(key);
            Node pn = p.next;
            if (pn.val != p.val + 1) {
                pn = new Node(p.val + 1);
                list.insertBack(p, pn);
            }
            pn.content.add(key);
            p.content.remove(key);
            if (p.content.isEmpty()) list.delete(p);
            mp.put(key, pn);
        }else {
            Node p = list.head.next;
            if (p.val != 1) {
                p = new Node(1);
                list.insertBack(list.head, p);
            }
            p.content.add(key);
            mp.put(key, p);
        }
    }

    public void dec(String key) {
        if (!mp.containsKey(key)) return;
        Node p = mp.get(key);
        if (p.val == 1) {
            p.content.remove(key);
            if (p.content.isEmpty()) {
                list.delete(p);
                mp.remove(key);
            }
        }else {
            Node pr = p.pre;
            if (pr.val != p.val - 1) {
                pr = new Node(p.val - 1);
                list.insert(p, pr);
            }
            pr.content.add(key);
            p.content.remove(key);
            if (p.content.isEmpty()) list.delete(p);
            mp.put(key, pr);
        }
    }

    public String getMaxKey() {
        Node mx = list.tail.pre;
        return mx.val > 0 ? mx.content.iterator().next() : "";
    }

    public String getMinKey() {
        Node mn = list.head.next;
        return mn.val > 0 ? mn.content.iterator().next() : "";
    }
}