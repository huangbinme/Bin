package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    int capacity;

    Map<Integer, Node> numMap;

    Map<Integer, Node> freMap;

    int minFre = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.numMap = new HashMap<>();
        this.freMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = getNodeByKey(key);
        if (node == null) return -1;
        return node.v;
    }

    public void put(int key, int value) {
        Node node = getNodeByKey(key);
        if (node != null) {
            node.v = value;
        } else {
            if (capacity == numMap.size()) {
                Node removeNode = freMap.get(minFre).pre;
                numMap.remove(removeNode.k);
                removeNode(removeNode);
            }
            Node insertNode = new Node(key, value);
            numMap.put(key, insertNode);
            insertNode(insertNode, 1);
            minFre = 1;
        }
    }

    private void insertNode(Node node, int fre) {
        Node head = freMap.computeIfAbsent(fre, k -> createDummy());
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private Node createDummy() {
        Node node = new Node(-1, -1);
        node.next = node;
        node.pre = node;
        return node;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }

    private Node getNodeByKey(int k) {
        Node node = numMap.get(k);
        if (node == null) return null;
        Node freNodeHead = freMap.get(node.fre);
        removeNode(node);
        if (freNodeHead.pre == freNodeHead) {
            freMap.remove(node.fre);
            if (minFre == node.fre) minFre++;
        }
        node.fre++;
        insertNode(node, node.fre);
        return node;
    }

    static class Node {
        int k, v, fre = 1;
        Node pre, next;

        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }
}