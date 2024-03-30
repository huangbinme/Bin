package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int max;
    Map<Integer, Node> map = new HashMap<>();
    Node dummyHead;
    Node dummyTail;

    public LRUCache(int capacity) {
        max = capacity;
        dummyHead = new Node(-1, -1);
        dummyTail = new Node(-1, -1);
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            Node insert = new Node(key, value);
            map.put(key, insert);
            insertToHead(insert);
            if (map.size() > max) {
                map.remove(dummyTail.pre.key);
                Node tailPre = dummyTail.pre.pre;
                tailPre.next = dummyTail;
                dummyTail.pre = tailPre;
            }
        }
    }
    private void moveToHead(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        insertToHead(node);
    }

    private void insertToHead(Node insert) {
        Node head = dummyHead.next;
        dummyHead.next = insert;
        insert.pre = dummyHead;
        insert.next = head;
        head.pre = insert;
    }

    public class Node {
        Node pre;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
