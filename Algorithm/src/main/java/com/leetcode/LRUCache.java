package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final int maxCapacity;
    private final Map<Integer, Node> map = new HashMap();
    private final Node head;
    private final Node tail;
    private int curCapacity;

    public LRUCache(int capacity) {
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.pre = head;
        this.maxCapacity = capacity;
        this.curCapacity = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node cur = map.get(key);
        int returnValue = cur.value;
        moveToHead(cur);
        return returnValue;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.value = value;
            moveToHead(cur);
            return;
        }
        //add new node to first after head, and map
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        Node firstAfterHead = this.head.next;
        this.head.next = newNode;
        newNode.pre = this.head;
        newNode.next = firstAfterHead;
        firstAfterHead.pre = newNode;
        this.curCapacity++;
        //to check capacity
        if (this.curCapacity > maxCapacity) {
            Node removeNode = this.tail.pre;
            Node pre = removeNode.pre;
            pre.next = this.tail;
            this.tail.pre = pre;
            map.remove(removeNode.key);
            this.curCapacity--;
        }
    }

    public void moveToHead(Node cur) {
        Node pre = cur.pre;
        Node next = cur.next;
        pre.next = next;
        next.pre = pre;
        Node firstAfterHead = this.head.next;
        this.head.next = cur;
        cur.pre = this.head;
        cur.next = firstAfterHead;
        firstAfterHead.pre = cur;
    }

    public class Node {
        public Integer key;
        public Integer value;
        public Node pre;
        public Node next;

        public Node(Integer key, Integer value) {
            this.value = value;
            this.key = key;
        }
    }
}
