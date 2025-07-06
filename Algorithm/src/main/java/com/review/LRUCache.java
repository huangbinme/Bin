package com.review;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Node mockHead;
    Node mockTail;

    Map<Integer, Node> map;

    int capacity;


    public LRUCache(int capacity) {
        mockHead = new Node(-1, -1);
        mockTail = new Node(-1, -1);
        mockHead.next = mockTail;
        mockTail.pre = mockHead;
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            moveNodeToHead(node);
            return node.v;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.v = value;
            moveNodeToHead(node);
        } else {
            if (map.size() == capacity) {
                Node remove = removeLastNode();
                map.remove(remove.k);
            }
            Node addNode = new Node(key, value);
            map.put(key, addNode);
            addNodeToHead(addNode);
        }
    }

    private void addNodeToHead(Node node) {
        Node oldHead = mockHead.next;
        mockHead.next = node;
        node.pre = mockHead;
        node.next = oldHead;
        oldHead.pre = node;
    }

    private Node removeLastNode() {
        Node last = mockTail.pre;
        Node lastPre = last.pre;
        lastPre.next = mockTail;
        mockTail.pre = lastPre;
        last.pre = null;
        last.next = null;
        return last;
    }


    private void moveNodeToHead(Node n) {
        Node pre = n.pre, next = n.next;
        pre.next = next;
        next.pre = pre;
        n.pre = null;
        n.next = null;
        addNodeToHead(n);
    }

    public static class Node {
        Node pre;
        Node next;
        int v;
        int k;

        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }
}
